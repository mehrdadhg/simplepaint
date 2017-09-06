package model;

import java.awt.*;


public class Rect extends Shape {
    private int id;
    private int rgb;
    private String type;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int width;
    private int height;
    private Point startPoint;
    private Point endPoint;
    private Color color;

    public Rect(int rgb, String type, int x1, int x2, int y1, int y2) {
        this.rgb = rgb;
        this.type = type;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        width=Math.abs((x2 - x1));
        height=Math.abs((y2 - y1));//dimension
        startPoint=new Point(x1,y1);
        endPoint=new Point(x2,y2);
        color=new Color(rgb);
    }
    public Rect(int id, int rgb, String type, int x1, int x2, int y1, int y2 ) {
        super(id, rgb, type, x1, x2, y1, y2);
        width=Math.abs((x2 - x1));
        height=Math.abs((y2 - y1));//dimension
        startPoint=new Point(x1,y1);
        endPoint=new Point(x2,y2);
       color=new Color(rgb);
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

    public void setColor(int rgb) {
        this.color = new Color(rgb);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
