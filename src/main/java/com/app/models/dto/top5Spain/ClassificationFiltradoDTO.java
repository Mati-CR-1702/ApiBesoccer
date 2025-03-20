package com.app.models.dto.top5Spain;

public class ClassificationFiltradoDTO {

    public String id;
    public String group;
    public String team;
    public String points;
    public String wins;
    public String draws;
    public String losses;
    public String gf;
    public String ga;
    public String avg;
    public String abbr;
    public String pos;


    public ClassificationFiltradoDTO(String id, String group, String team,
                                     String points, String wins, String draws, String losses, String gf, String ga,
                                     String avg, String abbr, String pos) {
        this.id = id;
        this.group = group;
        this.team = team;
        this.points = points;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.gf = gf;
        this.ga = ga;
        this.avg = avg;
        this.abbr = abbr;
        this.pos = pos;
    }
}
