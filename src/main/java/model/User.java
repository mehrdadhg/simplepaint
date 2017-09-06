package model;

import java.util.Set;

public class User {
    private int id;
    private String uName;
    private String password;
    private Set<Shape> shapes;

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

    public Set<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(Set<Shape> shapes) {
        this.shapes = shapes;
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
