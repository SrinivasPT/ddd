package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Product implements ValueObject {
    private final ProductId id;
    private final String name;
    private final Long price;

    @JsonCreator
    public Product(@JsonProperty("id") @NonNull ProductId id,
                   @JsonProperty("name") @NonNull String name,
                   @JsonProperty("price") @NonNull Long price
    ) {
        this.id = Objects.requireNonNull(id, "id should not be null");
        this.name = Objects.requireNonNull(name, "name should not be null");
        this.price = Objects.requireNonNull(price, "price should not be null");
    }

    @NonNull
    public ProductId id() {
        return id;
    }

    @NonNull
    public String name() {
        return name;
    }

    @NonNull
    public Long price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
