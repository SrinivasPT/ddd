package com.edge.kernel.infra.eventlog;

import com.edge.kernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

public interface RemoteEventTranslator {

    /**
     * Returns whether this translator supports the given remote event (i.e. knows how to translate it).
     */
    boolean supports(@NonNull StoredDomainEvent remoteEvent);

    /**
     * Translates the {@link StoredDomainEvent#toJsonString() JSON} of the given remote event into a local
     * {@link DomainEvent}.
     */
    @NonNull
    Optional<DomainEvent> translate(@NonNull StoredDomainEvent remoteEvent);
}
