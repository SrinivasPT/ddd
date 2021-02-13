package com.edge.invoice.integration;

import com.edge.kernel.domain.base.DomainEvent;
import com.edge.kernel.infra.eventlog.RemoteEventTranslator;
import com.edge.kernel.infra.eventlog.StoredDomainEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.NonNull;

import java.util.Optional;

@Service
class OrderProcessedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    OrderProcessedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(@NonNull StoredDomainEvent remoteEvent) {
        return remoteEvent.domainEventClassName().equals("net.pkhapps.ddd.orders.domain.model.event.OrderStateChanged");
    }

    @Override
    @NonNull
    public Optional<DomainEvent> translate(@NonNull StoredDomainEvent remoteEvent) {
        var orderStateChanged = remoteEvent.toDomainEvent(objectMapper, OrderStateChangedEvent.class);
        if (orderStateChanged.state().equals("PROCESSED")) {
            return Optional.of(new OrderProcessedEvent(orderStateChanged.orderId(), orderStateChanged.occurredOn()));
        }
        return Optional.empty();
    }
}