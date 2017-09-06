package model;

import java.util.Set;

public class User {
    private int id;
    private String uName;
    private String password;
    private Set<Line> lines;
    private Set<Rect> rects;
    private Set<Circle> circles;

    public User(){}
    public User (int id, String uName, String password) {
        this.id = id;
        this.uName = uName;
        this.password = password;
    }

    public User (String uName, String password) {
        this.uName = uName;
        this.password = password;
    }

    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }

    public Set<Rect> getRects() {
        return rects;
    }

    public void setRects(Set<Rect> rects) {
        this.rects = rects;
    }

    public Set<Circle> getCircles() {
        return circles;
    }

    public void setCircles(Set<Circle> circles) {
        this.circles = circles;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getuName () {
        return uName;
    }

    public void setuName (String uName) {
        this.uName = uName;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }
}
