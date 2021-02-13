package com.edge.kernel.domain.financial;

import com.edge.kernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Money implements ValueObject {
    @JsonProperty("currency")
    private final Currency currency;
    @JsonProperty("amount")
    private final int amount;

    @JsonCreator
    public Money(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = (int) amount * 100;
    }

    public static Money valueOf(Currency currency, Integer value) {
        if (currency == null || value == null) {
            return null;
        }

        return new Money(currency, value);
    }


    public Money add(Money money) {
        return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money) {
        return new Money(currency, amount - money.amount);
    }

    public Currency currency() {
        return currency;
    }

    public int fixedPointAmount() {
        return amount;
    }

    public double amount() {
        return amount / 100d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
