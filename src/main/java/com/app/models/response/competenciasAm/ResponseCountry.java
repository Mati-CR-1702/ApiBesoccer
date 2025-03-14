package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.CountryDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCountry {

    private List<CountryDto> countries;

    public List<CountryDto> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDto> countries) {
        this.countries = countries;
    }
}
