package model;

import java.awt.*;


public class Rect extends Shape {
    private int id;
    private Point startPoint;
    private Point endPoint;
    private int width;
    private int height;
    private Color color;
    private String type;

    public Rect(Color color, String type,Point startPoint, Point endPoint ) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.type = type;
        width=Math.abs((endPoint.x - startPoint.x));
        height=Math.abs((endPoint.y - startPoint.y));//dimension
    }

    public Rect() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void draw(Graphics g) {
        g.drawRect(Math.min(startPoint.x,endPoint.x),Math.min(startPoint.y,endPoint.y),width,height);
    }

    public boolean contains(Point p) {

        int y1, y2, x1, x2;
        if (startPoint.y >= endPoint.y) {
            y1 = startPoint.y;
            y2 = endPoint.y;
        } else {
            y1 = endPoint.y;
            y2 = startPoint.y;
        }
        if (startPoint.x >= endPoint.x) {
            x1 = startPoint.x;
            x2 = endPoint.x;
        } else {
            x1 = endPoint.x;
            x2 = startPoint.x;
        }

        return (((p.x == endPoint.x || p.x == startPoint.x || p.x == endPoint.x - 1 || p.x == startPoint.x - 1 || p.x == endPoint.x + 1 || p.x == startPoint.x + 1) && p.y > y2 && p.y < y1) || ((p.y == endPoint.y || p.y == startPoint.y || p.y == endPoint.y - 1 || p.y == startPoint.y - 1 || p.y == endPoint.y + 1 || p.y == startPoint.y + 1) && p.x > x2 && p.x < x1));
    }

    public void resize(double n) {
        if(n<0){
            if(endPoint.x>startPoint.x && endPoint.y>startPoint.y) {
                endPoint.x -= width * Math.abs(n);
                endPoint.y -= height * Math.abs(n);
            }else if(endPoint.x<startPoint.x && endPoint.y>startPoint.y){
                endPoint.x += width * Math.abs(n);
                endPoint.y -= height * Math.abs(n);
            }else if(endPoint.x>startPoint.x && endPoint.y<startPoint.y){
                endPoint.x -= width * Math.abs(n);
                endPoint.y += height * Math.abs(n);
            }else if(endPoint.x<startPoint.x && endPoint.y<startPoint.y){
                endPoint.x += width * Math.abs(n);
                endPoint.y += height * Math.abs(n);
            }
        }else{
            if(endPoint.x>startPoint.x && endPoint.y>startPoint.y) {
                endPoint.x += width * Math.abs(n);
                endPoint.y += height * Math.abs(n);
            }else if(endPoint.x<startPoint.x && endPoint.y>startPoint.y){
                endPoint.x -= width * Math.abs(n);
                endPoint.y += height * Math.abs(n);
            }else if(endPoint.x>startPoint.x && endPoint.y<startPoint.y){
                endPoint.x += width * Math.abs(n);
                endPoint.y -= height * Math.abs(n);
            }else if(endPoint.x<startPoint.x && endPoint.y<startPoint.y){
                endPoint.x -= width * Math.abs(n);
                endPoint.y -= height * Math.abs(n);
            }
        }
        width+=width*n;
        height+=height*n;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColor(int color) {
        this.color = new Color(color);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
