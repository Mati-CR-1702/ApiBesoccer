package com.app.models.dto.top5España;

public class TeamDTO {

    public String id;
    public String group;
    public Object groupName;
    public String team;
    public String points;
    public int wins;
    public int draws;
    public int losses;
    public String gf;
    public String ga;
    public int avg;
    public String abbr;
    public String pos;


    public TeamDTO(String id, String group, Object groupName, String team,
                   String points, int wins, int draws, int losses, String gf, String ga,
                   int avg, String abbr, String pos) {
        this.id = id;
        this.group = group;
        this.groupName = groupName;
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
