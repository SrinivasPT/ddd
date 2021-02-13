package com.edge.kernel.domain.financial;

import com.edge.kernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public class VAT implements ValueObject {
    private final int percentage;

    @JsonCreator
    public VAT(int percentage) {
        this.percentage = percentage;
    }

    public static VAT valueOf(Integer percentage) {
        return percentage == null ? null : new VAT(percentage);
    }

    @JsonValue
    public int toInteger() {
        return percentage;
    }

    public double toDouble() {
        return percentage / 100d;
    }

    public Money addTax(Money amount) {
        Objects.requireNonNull(amount, "amount must not be null");
        return amount.add(calculateTax(amount));
    }

    public Money subtractTax(Money amount) {
        Objects.requireNonNull(amount, "amount must not be null");
        return amount.subtract(calculateTax(amount));
    }

    private Money calculateTax(Money amount) {
        var tax = amount.fixedPointAmount() * 100 / (percentage + 100);
        return new Money(amount.currency(), tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VAT vat = (VAT) o;
        return percentage == vat.percentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentage);
    }

    @Override
    public String toString() {
        return String.format("%d %%", percentage);
    }
}
