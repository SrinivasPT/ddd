package com.edge.kernel.domain.base;

import org.springframework.lang.NonNull;

import java.time.Instant;

public interface DomainEvent extends DomainObject {

    /**
     * Returns the time and date on which the event occurred.
     */
    @NonNull
    Instant occurredOn();
}