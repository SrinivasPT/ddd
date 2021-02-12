package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class OrderStateChange implements ValueObject {
    private Instant changedOn;
    @Enumerated(EnumType.STRING)
    private OrderState state;

    public OrderStateChange() {
    }

    OrderStateChange(Instant changedOn, OrderState state){
        this.changedOn = Objects.requireNonNull(changedOn, "Changed on can't be null");
        this.state = Objects.requireNonNull(state, "State on can't be null");
    }

    @NonNull
    @JsonProperty("changedOn")
    public Instant changedOn(){
        return changedOn;
    }

    @NonNull
    @JsonProperty("state")
    public OrderState state(){
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStateChange that = (OrderStateChange) o;
        return Objects.equals(changedOn, that.changedOn) && state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(changedOn, state);
    }
}
