package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.AbstractAggregateRoot;
import com.edge.kernel.domain.base.DomainObjectId;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
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
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "billing_name", nullable = false)),
            @AttributeOverride(name = "addressLine1", column = @Column(name = "billing_address_line1", nullable = false)),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "billing_address_line2", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city", nullable = false)),
            @AttributeOverride(name = "country", column = @Column(name = "billing_country", nullable = false)),
            @AttributeOverride(name = "pin", column = @Column(name = "billing_pin", nullable = false))
    })
    private RecipientAddress billingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "shipping_name", nullable = false)),
            @AttributeOverride(name = "addressLine1", column = @Column(name = "shipping_address_line1", nullable = false)),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "shipping_address_line2", nullable = false)),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city", nullable = false)),
            @AttributeOverride(name = "country", column = @Column(name = "shipping_country", nullable = false)),
            @AttributeOverride(name = "pin", column = @Column(name = "shipping_pin", nullable = false))
    })
    private RecipientAddress shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    private Set<OrderItem> orderItems;

    public Order() {
    }

    public Order(Instant orderedOn,
                 String currency, RecipientAddress billingAddress,
                 RecipientAddress shippingAddress) {
        super(DomainObjectId.randomId(OrderId.class));
        this.orderItems = new HashSet<>();
        setVersion(version);
        setOrderedOn(orderedOn);
        setCurrency(currency);
        setBillingAddress(billingAddress);
        setShippingAddress(shippingAddress);
    }

    public void addItem(OrderItem orderItems) {
        this.orderItems.add(orderItems);
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

    @JsonProperty("currency")
    public String currency() {
        return currency;
    }

    @JsonProperty("orderedOn")
    public Instant orderedOn() {
        return orderedOn;
    }

    @JsonProperty("version")
    public Long version() {
        return version;
    }

    @JsonProperty("billingAddress")
    public RecipientAddress billingAddress() {
        return billingAddress;
    }

    @JsonProperty("shippingAddress")
    public RecipientAddress shippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("orderItems")
    public Set<OrderItem> orderItems() {
        return orderItems;
    }
}
