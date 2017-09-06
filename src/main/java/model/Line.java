package model;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Shape{
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

    public Line(int rgb, String type, int x1, int x2, int y1, int y2) {
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
    public Line (int id, int rgb, String type, int x1, int x2, int y1, int y2 ) {
        super(id, rgb, type, x1, x2, y1, y2);
        width=Math.abs((x2 - x1));
        height=Math.abs((y2 - y1));//dimension
        startPoint=new Point(x1,y1);
        endPoint=new Point(x2,y2);
        color=new Color(rgb);
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
