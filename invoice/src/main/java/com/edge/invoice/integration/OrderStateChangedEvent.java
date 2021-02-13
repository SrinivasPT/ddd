package com.edge.invoice.integration;

import com.edge.invoice.domain.model.OrderId;
import com.edge.kernel.domain.base.DomainEvent;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.Instant;

public class OrderStateChangedEvent implements DomainEvent {
    private final Instant occurredOn;
    private final OrderId orderId;
    private final String state;

    @JsonCreator
    public OrderStateChangedEvent(Instant occurredOn, OrderId orderId, String state) {
        this.occurredOn = occurredOn;
        this.orderId = orderId;
        this.state = state;
    }

    public Instant occurredOn() {
        return occurredOn;
    }

    public OrderId orderId() {
        return orderId;
    }

    public String state() {
        return state;
    }
}
