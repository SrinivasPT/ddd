package com.edge.invoice.domain.model;

import com.edge.kernel.domain.base.AbstractEntity;
import com.edge.kernel.domain.financial.VAT;

import javax.persistence.Entity;
import java.util.Currency;

@Entity
public class InvoiceItem extends AbstractEntity<InvoiceItemId> {
    private String description;
    private Currency currency;
    private Long price;
    private VAT vat;
    private int quantity;
    private int subtotalExcludingVat;
    private int subtotalVat;
    private int subtotalIncludingVat;

    public InvoiceItem(String description, Currency currency, Long price, VAT vat, int quantity) {
        this.description = description;
        this.currency = currency;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }

    public String description() {
        return description;
    }

    public Currency currency() {
        return currency;
    }

    public Long price() {
        return price;
    }

    public VAT vat() {
        return vat;
    }
}
