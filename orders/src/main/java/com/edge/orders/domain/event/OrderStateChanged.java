package com.edge.orders.domain.event;

import com.edge.kernel.domain.base.DomainEvent;
import com.edge.orders.domain.model.OrderId;
import com.edge.orders.domain.model.OrderState;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Objects;

public class OrderStateChanged implements DomainEvent {
    @JsonProperty("orderId")
    private final OrderId orderId;
    @JsonProperty("orderState")
    private final OrderState orderState;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public OrderStateChanged(OrderId orderId, OrderState orderState, Instant occurredOn){
        this.orderId = Objects.requireNonNull(orderId, "Order ID can't be null");
        this.orderState = Objects.requireNonNull(orderState, "orderState ID can't be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn ID can't be null");
    }

    public OrderId orderId(){
        return orderId;
    }

    public OrderState orderState(){
        return orderState;
    }

    public Instant occurredOn(){
        return occurredOn;
    }

}
