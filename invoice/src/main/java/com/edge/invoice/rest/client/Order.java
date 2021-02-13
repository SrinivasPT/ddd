package com.edge.invoice.rest.client;

import com.edge.invoice.domain.model.OrderId;
import com.edge.kernel.domain.financial.Currency;

import java.util.Set;

public class Order {
    private OrderId id;
    private Currency currency;
    private Set<OrderItem> items;
}
