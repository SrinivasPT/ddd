package com.edge.kernel.domain.base;

public interface DeletableDomainObject extends DomainObject {

    /**
     * Returns whether this domain object has been marked as deleted.
     */
    boolean isDeleted();

    /**
     * Marks this domain object as deleted.
     */
    void delete();
}