package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.DomainObjectId;

import java.util.UUID;

public class OrderId extends DomainObjectId {
    public OrderId(UUID uuid) {
        super(uuid);
    }
}
