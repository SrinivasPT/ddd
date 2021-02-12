package com.edge.kernel.domain.financial;

import com.edge.kernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class VAT implements ValueObject {
    private final int percentage;

    @JsonCreator
    public VAT(int percentage) {
        this.percentage = percentage;
    }

    public static VAT valueOf(Integer percentage){
        return percentage == null? null : new VAT(percentage);
    }

    @JsonValue
    public int toInteger(){
        return percentage;
    }

    public double toDouble(){
        return percentage / 100d;
    }
}
