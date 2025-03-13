package com.app.models.dto.competenciasAm;

import java.util.ArrayList;

public class DtoCountry {

    public String id;
    public String name;
    public String country;
    public String continent;
    public String competitions;
    public String alias;
    public String flag;

    public class Root{
        public ArrayList<DtoCountry> countries;
    }
}

