package com.edge.invoice.rest.client;

import com.edge.kernel.domain.financial.Money;
import com.edge.kernel.domain.financial.VAT;

public class OrderItem {
    private String description;
    private Money price;
    private VAT vat;
    private int quantity;

    public OrderItem() {
    }

    public String description() {
        return description;
    }

    public Money price() {
        return price;
    }

    public VAT vat() {
        return vat;
    }

    public int quantity() {
        return quantity;
    }
}
