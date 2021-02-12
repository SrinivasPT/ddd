package com.edge.invoice.domain.model;

import com.edge.kernel.domain.base.DomainObjectId;

import java.util.UUID;

public class InvoiceId extends DomainObjectId {
    public InvoiceId(UUID uuid) {
        super(uuid);
    }
}
