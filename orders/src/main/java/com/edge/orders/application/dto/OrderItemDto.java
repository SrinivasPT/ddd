package com.edge.orders.application.dto;

import com.edge.orders.domain.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderItemDto {
    @NotNull
    private Product product;
    @Min(1)
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
