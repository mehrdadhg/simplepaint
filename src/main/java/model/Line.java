package model;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Shape{
    private int id;
    private Point startPoint;
    private Point endPoint;
    private Color color;
    private String type;
    private int width;
    private int height;

    public Line ( Color color, String type,Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.type = type;
        width=Math.abs((endPoint.x - startPoint.x));
        height=Math.abs((endPoint.y - startPoint.y));//dimension
    }
    public Line(){
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void draw(Graphics g){
       // g.drawRect(startPoint.x, startPoint.y, (endPoint.x - startPoint.x), (endPoint.y - startPoint.y));
        g.drawLine (startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    public boolean contains(Point p){
      /*  int dx = (int) Math.pow ((startPoint.x - endPoint.x), 2);
        int dy =  (int) Math.pow ((startPoint.y - endPoint.y), 2);
        int d =(int)  Math.sqrt (dx + dy);
        double m1=   Math.tan(d);

        return (p.y==(m1*(p.x-endPoint.x))+endPoint.y)||(p.y==(m1*(p.x-(endPoint.x+1)))+endPoint.y+1)||(p.y==(m1*(p.x-(endPoint.x-1)))+endPoint.y-1);*/

        return new Line2D.Double(startPoint, endPoint).ptLineDist(p) <= 1;
    }
    public  void resize(double n){
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
    }

    public Point getStartPoint () {
        return startPoint;
    }

    public void setStartPoint (Point startPoint) {
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

    public void setColor (int color) {
        this.color=new Color (color);
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
}
