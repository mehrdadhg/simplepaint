

import java.awt.*;


public class Circle extends Shape {

   // private int id;
    private Point startPoint;
    private Point endPoint;
    private int radius;
    private Color color;
    private String type;

    public Circle (Color color, String type,Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.type = type;
        //cALculate radius
        int dx = (int) Math.pow ((endPoint.x - this.startPoint.x), 2);
        int dy = (int) Math.pow ((endPoint.y - this.startPoint.y), 2);
        radius = (int) Math.sqrt (dx + dy);
    }
    public Circle(){}

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
