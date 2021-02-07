package com.edge.orders.application.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class OrderDto implements Serializable {
    @NotNull
    private String currency;
    @Valid
    @NotNull
    private RecipientAddressDto billingAddressDto = new RecipientAddressDto();
    @Valid
    @NotNull
    private RecipientAddressDto shippingAddressDto = new RecipientAddressDto();
    @Valid
    @NotEmpty
    private List<OrderItemDto> items = new ArrayList<>();

    public String getCurrency() {
        return currency;
    }

    public RecipientAddressDto getBillingAddress() {
        return billingAddressDto;
    }

    public RecipientAddressDto getShippingAddress() {
        return shippingAddressDto;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }
}
