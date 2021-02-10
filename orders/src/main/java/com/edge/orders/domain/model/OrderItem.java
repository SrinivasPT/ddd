package com.edge.orders.domain.model;

import com.edge.kernel.domain.base.AbstractEntity;
import com.edge.kernel.domain.base.DomainObjectId;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OrderItem extends AbstractEntity<OrderItemId> {

    @Column(nullable = false)
    private ProductId productId;
    @Column(nullable = false)
    private String itemDescription;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Integer quantity;

    private OrderItem() {
    }

    public OrderItem(OrderItemId id, ProductId productId,
                     String itemDescription, String currency,
                     Long price, Integer quantity) {
        super(DomainObjectId.randomId(OrderItemId.class));
        setProductId(productId);
        setItemDescription(itemDescription);
        setCurrency(currency);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setProductId(@NonNull ProductId productId) {
        this.productId = productId;
    }

    public void setItemDescription(@NonNull String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setCurrency(@NonNull String currency) {
        this.currency = currency;
    }

    public void setPrice(@NonNull Long price) {
        this.price = price;
    }

    public void setQuantity(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("productId")
    public ProductId productId() {
        return productId;
    }

    @JsonProperty("itemDescription")
    public String itemDescription() {
        return itemDescription;
    }

    @JsonProperty("currency")
    public String currency() {
        return currency;
    }

    @JsonProperty("price")
    public Long price() {
        return price;
    }

    @JsonProperty("quantity")
    public Integer quantity() {
        return quantity;
    }
}
