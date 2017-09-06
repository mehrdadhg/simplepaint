package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.awt.*;
import java.util.ArrayList;

public abstract   class Shape {
    public static final String line="line";
    public static final String circle="circle";
    public static final String rect="rect";
    public static final String pencil="pencil";
    private int id;
    private int rgb;
    private String type;
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    public Shape () {
    }

    public Shape(int rgb, String type, int x1, int x2, int y1, int y2) {
        this.rgb = rgb;
        this.type = type;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Shape(int id, int rgb, String type, int x1, int x2, int y1, int y2) {
        this.id = id;
        this.rgb = rgb;
        this.type = type;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public  void resize(double n){}
    public  void draw(Graphics g){}

    public abstract   boolean contains(Point p);

    public abstract   Point getStartPoint() ;

    public abstract   Point getEndPoint() ;

    public int getRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }

    public String getType() {
        return type;
    }
}
