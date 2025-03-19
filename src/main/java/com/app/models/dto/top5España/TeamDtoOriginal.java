package com.app.models.dto.top5España;

public class TeamDtoOriginal {

    public String id;
    public String group;
    public Object group_name;
    public String conference;
    public String team;
    public String points;
    public String wins;
    public String draws;
    public String losses;
    public String shield;
    public String cflag;
    public String basealias;
    public String gf;
    public String ga;
    public String avg;
    public String matchs_coef;
    public String points_coef;
    public String coef;
    public Object coefficients;
    public String mark;
    public String class_mark;
    public String round;
    public String pos;
    public String countrycode;
    public String abbr;
    public String form;
    public String direction;

    public TeamDtoOriginal(String id, String group, Object group_name, String conference, String team,
                           String points, String wins, String draws, String shield, String losses, String basealias,
                           String cflag, String gf, String ga, String avg, String matchs_coef, String coef,
                           String points_coef, Object coefficients, String mark, String class_mark, String round,
                           String pos, String countrycode, String abbr, String form, String direction) {
        this.id = id;
        this.group = group;
        this.group_name = group_name;
        this.conference = conference;
        this.team = team;
        this.points = points;
        this.wins = wins;
        this.draws = draws;
        this.shield = shield;
        this.losses = losses;
        this.basealias = basealias;
        this.cflag = cflag;
        this.gf = gf;
        this.ga = ga;
        this.avg = avg;
        this.matchs_coef = matchs_coef;
        this.coef = coef;
        this.points_coef = points_coef;
        this.coefficients = coefficients;
        this.mark = mark;
        this.class_mark = class_mark;
        this.round = round;
        this.pos = pos;
        this.countrycode = countrycode;
        this.abbr = abbr;
        this.form = form;
        this.direction = direction;
    }
}
