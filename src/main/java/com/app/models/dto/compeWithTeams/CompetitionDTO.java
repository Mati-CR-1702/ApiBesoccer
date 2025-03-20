package com.app.models.dto.compeWithTeams;

public class CompetitionDTO {


        public String id;
        public String name;
        public String country;
        public String flag;
        public String logo;

        public CompetitionDTO(String id, String name, String country, String flag, String logo) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.flag = flag;
            this.logo = logo;
        }
}
