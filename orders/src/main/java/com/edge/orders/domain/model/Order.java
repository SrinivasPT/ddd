package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractAggregateRoot<OrderId> {
    @Version
    private Long version;
    @Column(nullable = false)
    private Instant orderedOn;
    private String currency;
    @Embedded
    private RecipientAddress billingAddress;
    @Embedded
    private RecipientAddress shippingAddress;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems;

    public Order() {
    }

    public Order(Instant orderedOn,
                 String currency, RecipientAddress billingAddress,
                 RecipientAddress shippingAddress) {
        setVersion(version);
        setOrderedOn(orderedOn);
        setCurrency(currency);
        setBillingAddress(billingAddress);
        setBillingAddress(shippingAddress);
    }

    private void setVersion(Long version) {
        this.version = version;
    }

    private void setOrderedOn(Instant orderedOn) {
        this.orderedOn = orderedOn;
    }

    private void setCurrency(String currency) {
        this.currency = currency;
    }

    private void setBillingAddress(RecipientAddress billingAddress) {
        this.billingAddress = Objects.requireNonNull(billingAddress, "Billing address is missing");
    }

    private void setShippingAddress(RecipientAddress shippingAddress) {
        this.shippingAddress = Objects.requireNonNull(shippingAddress, "Shipping address is missing");
    }
}
