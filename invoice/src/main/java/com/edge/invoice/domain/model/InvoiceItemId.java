package com.edge.invoice.domain.model;

import com.edge.kernel.domain.base.DomainObjectId;

import java.util.UUID;

public class InvoiceItemId extends DomainObjectId {
    public InvoiceItemId(UUID uuid) {
        super(uuid);
    }
}
