package com.edge.invoice.domain.model;

import com.edge.kernel.domain.base.AbstractAggregateRoot;
import com.edge.kernel.domain.geo.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Version;
import java.time.Instant;
import java.util.Set;

@Entity
public class Invoice extends AbstractAggregateRoot<InvoiceId> {
    @Version
    private Long version;

    private Instant createdOn;
    private OrderId orderId;
    private int terms;
    private Instant dueDate;
    private String recipientName;

    @Embedded
    private Address address;
    private Set<InvoiceItem> items;

    public Invoice(Instant createdOn, OrderId orderId, int terms, Instant dueDate, String recipientName) {
        this.createdOn = createdOn;
        this.orderId = orderId;
        this.terms = terms;
        this.dueDate = dueDate;
        this.recipientName = recipientName;
    }

    public Long version() {
        return version;
    }

    public Instant createdOn() {
        return createdOn;
    }

    public OrderId orderId() {
        return orderId;
    }

    public int terms() {
        return terms;
    }

    public Instant dueDate() {
        return dueDate;
    }

    public String recipientName() {
        return recipientName;
    }
}
