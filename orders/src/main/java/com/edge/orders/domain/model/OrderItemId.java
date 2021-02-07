package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.DomainObjectId;

import java.util.UUID;

public class OrderItemId extends DomainObjectId {
    public OrderItemId(UUID uuid) {
        super(uuid);
    }
}
