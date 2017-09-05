import javax.persistence.Column;
import javax.persistence.Entity;
import java.awt.*;
import java.util.ArrayList;

@Entity
public abstract class Shape {
    public static final String line="line";
    public static final String circle="circle";
    public static final String rect="rect";
    public static final String pencil="pencil";
    private int id;
    private Color color;
    private String type;
    private Point startPoint;
    private Point endPoint;
    private ArrayList<Point> freeLine = new ArrayList<Point> ();

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
        this.freeLine=freeLine;
    }

    public abstract void resize(double n);
    public abstract void draw(Graphics g);

    public abstract boolean contains(Point p);

    public abstract Point getStartPoint() ;

    public abstract Point getEndPoint() ;

    public abstract Color getColor ();

    public abstract void setColor(Color color);
    public abstract void setColor(int color);

    public abstract String getType ();


}
