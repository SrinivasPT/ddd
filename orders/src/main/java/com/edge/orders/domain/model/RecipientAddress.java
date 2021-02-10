package com.edge.orders.domain.model;

import com.edge.kernel.domain.geo.Address;
import com.edge.kernel.domain.geo.CityName;
import com.edge.kernel.domain.geo.Country;
import com.edge.kernel.domain.geo.PIN;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Embeddable
@MappedSuperclass
public class RecipientAddress extends Address {
    private String name;

    public RecipientAddress() {
    }

    public RecipientAddress(@NonNull String name,
                            @NonNull String addressLine1,
                            @Nullable String addressLine2,
                            @NonNull CityName city,
                            @NonNull Country country,
                            @Nullable PIN pin) {
        super(addressLine1, addressLine2, city, country, pin);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RecipientAddress that = (RecipientAddress) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
