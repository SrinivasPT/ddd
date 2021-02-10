package com.edge.kernel.domain.geo;

import com.edge.kernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class PIN implements ValueObject {
    private final Long pin;

    @JsonCreator
    public PIN(@NonNull Long pin) {
        this.pin = Objects.requireNonNull(pin, "PIN is mandatory");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PIN pin1 = (PIN) o;
        return Objects.equals(pin, pin1.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin);
    }

    @Override
    @JsonValue
    public String toString() {
        return pin.toString();
    }
}
