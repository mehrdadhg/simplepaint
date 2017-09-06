package model;

import java.awt.*;


public class Circle extends Shape {

    private int id;
    private int rgb;
    private String type;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Point startPoint;
    private Point endPoint;
    private Color color;
    private int radius;

    public Circle(int rgb, String type, int x1, int x2, int y1, int y2) {
        this.rgb = rgb;
        this.type = type;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        startPoint=new Point(x1,y1);
        endPoint=new Point(x2,y2);
        color=new Color(rgb);
        int dx = (int) Math.pow ((endPoint.x - this.startPoint.x), 2);
        int dy = (int) Math.pow ((endPoint.y - this.startPoint.y), 2);
        radius = (int) Math.sqrt (dx + dy);
    }
    public Circle (int id, int rgb, String type, int x1, int x2, int y1, int y2 ) {
        super(id, rgb, type, x1, x2, y1, y2);
        startPoint=new Point(x1,y1);
        endPoint=new Point(x2,y2);
        color=new Color(rgb);
        //cALculate radius
        int dx = (int) Math.pow ((endPoint.x - this.startPoint.x), 2);
        int dy = (int) Math.pow ((endPoint.y - this.startPoint.y), 2);
        radius = (int) Math.sqrt (dx + dy);
    }
    public Circle(){}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void draw (Graphics g) {
        g.drawOval (startPoint.x - radius, startPoint.y - radius, 2 * radius, 2 * radius);

    }

    public boolean contains (Point p) {

        int cx = (int) Math.pow ((p.x - startPoint.x), 2);
        int cy = (int) Math.pow ((p.y - startPoint.y), 2);
        int d = (int) Math.sqrt (cx + cy);
        return (d == radius || d==radius-2 || d==radius-1);

    }
    public  void resize(double n){
        radius+=radius*n;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint () {
        return endPoint;
    }

    public void setEndPoint (Point endPoint) {
        this.endPoint = endPoint;
    }

    public Color getColor () {
        return color;
    }


    public void setColor (Color color) {
        this.color = color;
    }

    public void setColor (int rgb) {
        this.color=new Color (rgb);
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    @Override
    public int getRgb() {
        return rgb;
    }

    @Override
    public void setRgb(int rgb) {
        this.rgb = rgb;
    }

    @Override
    public int getX1() {
        return x1;
    }

    @Override
    public void setX1(int x1) {
        this.x1 = x1;
    }

    @Override
    public int getX2() {
        return x2;
    }

    @Override
    public void setX2(int x2) {
        this.x2 = x2;
    }

    @Override
    public int getY1() {
        return y1;
    }

    @Override
    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public int getY2() {
        return y2;
    }

    @Override
    public void setY2(int y2) {
        this.y2 = y2;
    }
}
