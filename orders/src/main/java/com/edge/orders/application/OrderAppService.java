package com.edge.orders.application;

import com.edge.orders.application.dto.OrderDto;
import com.edge.orders.application.dto.RecipientAddressDto;
import com.edge.orders.domain.model.Order;
import com.edge.orders.domain.model.OrderId;
import com.edge.orders.domain.model.RecipientAddress;
import com.edge.orders.infra.repository.OrderRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.time.Clock;
import java.util.Objects;


@Service
public class OrderAppService {
    private final Validator validator;
    private final OrderRepository orderRepository;
    private final Clock clock;

    public OrderAppService(Validator validator, OrderRepository orderRepository, Clock clock) {
        this.validator = validator;
        this.orderRepository = orderRepository;
        this.clock = clock;
    }

    public OrderId createOrder(@NonNull OrderDto form) {
        Objects.requireNonNull(form);
        var constraintViolations = validator.validate(form);
        var order = orderRepository.saveAndFlush(toDomainModel(form));
        return order.id();
    }

    private Order toDomainModel(@NonNull OrderDto orderDto) {
        var order = new Order(clock.instant(),
                orderDto.getCurrency(),
                toDomainModel(orderDto.getBillingAddress()),
                toDomainModel(orderDto.getShippingAddress()));
        return order;
    }

    private RecipientAddress toDomainModel(RecipientAddressDto recipientAddressDto) {
        return new RecipientAddress(recipientAddressDto.getName(),
                recipientAddressDto.getAddressLine1(),
                recipientAddressDto.getAddressLine2(),
                recipientAddressDto.getCityName(), recipientAddressDto.getCountry(), recipientAddressDto.getPin());
    }
}
