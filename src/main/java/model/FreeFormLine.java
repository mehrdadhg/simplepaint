package model;

import java.awt.*;
import java.util.ArrayList;

public class FreeFormLine extends Shape {
//    private int id;
    private Color color;
    private String type;
    private Point startPoint;
    private Point endPoint;
    private ArrayList<Point> freeLine = new ArrayList<Point> ();

    public FreeFormLine (Color color, String type, ArrayList<Point> freeLine) {
        this.color = color;
        this.type = type;
        this.freeLine = freeLine;
    }

    public void draw(Graphics g){
        if(freeLine.size ()>1) {
            Point p1 = freeLine.get (0);
            for (int j = 1; j < freeLine.size (); j++) {
                Point p2 = freeLine.get (j);
                int x1 = p1.x;
                int y1 = p1.y;
                int x2 = p2.x;
                int y2 = p2.y;
                g.drawLine (x1, y1, x2, y2);
                p1 = p2;
            }
        }
    }
    public boolean contains(Point p){
        return this.freeLine.contains (p);
    }

    public  void resize(double n){}

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    public Color getColor () {
        return color;
    }

    public void setColor (Color color) {
        this.color = color;
    }
    public void setColor (int color) {
        this.color=new Color (color);
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public ArrayList<Point> getFreeLine () {
        return freeLine;
    }

    public void setFreeLine (ArrayList<Point> freeLine) {
        this.freeLine = freeLine;
    }
}
