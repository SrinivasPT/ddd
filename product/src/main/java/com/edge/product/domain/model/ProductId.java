package com.edge.product.domain.model;

import com.edge.kernel.domain.base.DomainObjectId;

import java.util.UUID;

public class ProductId extends DomainObjectId {
    public ProductId(UUID uuid) {
        super(uuid);
    }
}
