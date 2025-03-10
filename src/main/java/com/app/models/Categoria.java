package com.app.models;

import java.util.List;

public class Categoria {

    public String id;
    public String league_id;
    public int order;
    public String year;
    public String alias;
    public String shortName;
    public String logo;
    public String name;
    public String country;
    public String flag;
    public Legend legend;
    public List<LegendDict> legend_dict;

    public static class Legend {
        public String one;
        public String two;
        public String three;
        public String five;
    }

    public static class LegendDict {
        public int pos;
        public String title;
    }
}

