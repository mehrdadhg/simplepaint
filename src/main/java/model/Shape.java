package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.awt.*;
import java.util.ArrayList;

public  class Shape {
    public static final String line="line";
    public static final String circle="circle";
    public static final String rect="rect";
    public static final String pencil="pencil";
    private int id;
    private Color color;
    private String type;
    private Point startPoint;
    private Point endPoint;


    public Shape () {
    }

    public Shape (Color color, String type, Point startPoint, Point endPoint) {
        this.color = color;
        this.type = type;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Shape(ArrayList<Point> freeLine,String type,Color color){
        this.color = color;
        this.type = type;

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

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public  void resize(double n){}
    public  void draw(Graphics g){}

    public  boolean contains(Point p){return true;}

    public  Point getStartPoint() {return new Point();}

    public  Point getEndPoint() {return new Point();}

    public  Color getColor (){return new Color(999);}

    public  void setColor(Color color){}
    public  void setColor(int color){}

    public  String getType (){return "";}


}
