package com.edge.invoice.domain.model;

import com.edge.kernel.domain.base.AbstractAggregateRoot;
import com.edge.kernel.domain.geo.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Version;
import java.time.Instant;

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

}
