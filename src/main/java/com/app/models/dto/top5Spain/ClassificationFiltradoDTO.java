package com.app.models.dto.top5Spain;

public class ClassificationFiltradoDTO {

    private String id;
    private String group;
    private String team;
    private String points;
    private String wins;
    private String draws;
    private String losses;
    private String gf;
    private String ga;
    private String avg;
    private String abbr;
    private String pos;


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

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
