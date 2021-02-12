package com.edge.invoice.domain.model;

import com.edge.kernel.domain.base.AbstractEntity;

import java.util.Currency;

public class InvoiceItem extends AbstractEntity<InvoiceItemId> {
    private String description;
    private Currency currency;
    private Long price;
    private VAT vat;
}
