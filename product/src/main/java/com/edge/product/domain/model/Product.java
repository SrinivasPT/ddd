package com.edge.product.domain.model;

import com.edge.kernel.domain.base.AbstractAggregateRoot;
import com.edge.kernel.domain.base.ConcurrencySafeDomainObject;
import com.edge.kernel.domain.base.DeletableDomainObject;
import com.edge.kernel.domain.base.DomainObjectId;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product extends AbstractAggregateRoot<ProductId> implements DeletableDomainObject,
        ConcurrencySafeDomainObject {

    @Version
    private Long version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private Long price;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @SuppressWarnings("unused") // Used by JPA only
    private Product() {
    }

    public Product(@NonNull String name, String description,@NonNull Long price) {
        super(DomainObjectId.randomId(ProductId.class));
        setName(name);
        setPrice(price);
        setDescription(description);
    }

    @NonNull
    @JsonProperty("name")
    public String name() {
        return name;
    }

    private void setName(@NonNull String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    @Nullable
    @JsonProperty("description")
    public String description() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public void setPrice(@NonNull Long price){
        this.price = price;
    }

    @Override
    @Nullable
    public Long version() {
        return version;
    }

    @Override
    @JsonProperty("isDeleted")
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void delete() {
        this.deleted = true;
    }
}