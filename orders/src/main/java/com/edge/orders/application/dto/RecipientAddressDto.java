package com.edge.orders.application.dto;

import com.edge.kernel.domain.geo.CityName;
import com.edge.kernel.domain.geo.Country;
import com.edge.kernel.domain.geo.PIN;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RecipientAddressDto implements Serializable {
    @NotEmpty
    private String name;
    @NotEmpty
    private String addressLine1;
    private String addressLine2;
    @NotNull
    private CityName cityName;
    @NotNull
    private PIN pin;
    @NotNull
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public CityName getCityName() {
        return cityName;
    }

    public void setCityName(CityName cityName) {
        this.cityName = cityName;
    }

    public PIN getPin() {
        return pin;
    }

    public void setPin(PIN pin) {
        this.pin = pin;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
