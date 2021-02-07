package com.edge.kernel.domain.geo;

import com.edge.kernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class Address implements ValueObject {

    private String addressLine1;
    private String addressLine2;
    private CityName city;
    private Country country;
    private PIN pin;

    public Address() {
    }

    public Address(@NonNull String addressLine1, @NonNull String addressLine2,
                   @NonNull CityName city, @NonNull Country country, @NonNull PIN pin) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.pin = pin;
    }

    @Nullable
    public String getAddressLine1() {
        return addressLine1;
    }

    @Nullable
    public String getAddressLine2() {
        return addressLine2;
    }

    @Nullable
    public CityName getCity() {
        return city;
    }

    @Nullable
    public Country getCountry() {
        return country;
    }

    @Nullable
    public PIN getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressLine1, address.addressLine1) &&
                Objects.equals(addressLine2, address.addressLine2) &&
                Objects.equals(city, address.city) &&
                country == address.country &&
                Objects.equals(pin, address.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, city, country, pin);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city=" + city +
                ", country=" + country +
                ", pin=" + pin +
                '}';
    }
}
