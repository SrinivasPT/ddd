package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.DomainObjectId;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.UUID;

public class ProductId extends DomainObjectId {
    @JsonCreator
    public ProductId(String uuid){
        super(UUID.fromString(uuid));
    }
}
