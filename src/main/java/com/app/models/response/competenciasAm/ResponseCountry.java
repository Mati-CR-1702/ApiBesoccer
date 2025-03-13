package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.DtoCountry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCountry {

    private List<DtoCountry> countries;

    public List<DtoCountry> getCountries() {
        return countries;
    }

    public void setCountries(List<DtoCountry> countries) {
        this.countries = countries;
    }
}
