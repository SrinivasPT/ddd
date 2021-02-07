package com.edge.kernel.domain.geo;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class PIN {
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
    public String toString() {
        return "PIN{" +
                "pin=" + pin +
                '}';
    }
}
