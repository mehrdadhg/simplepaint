import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class DrawPanel extends JComponent implements MouseListener, MouseMotionListener {

    private Point startPoint = null;
    private Point endPoint = null;
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private int index;
    private ArrayList<Point> currentPen = null;

    private static String toolType = Shape.pencil;
    private static Color shapeColor = new Color(250, 250, 250);


    public DrawPanel() {
        super();
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(MainFrame.width - 120, MainFrame.height - 20));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }


    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();

        if (toolType.equals(Shape.pencil)) {
            currentPen = new ArrayList<Point>();
            currentPen.add(e.getPoint());
            //repaint ();
        }
        if (toolType.equals("color")) {
            if (shapes.size() > 0) {
                for (int i = 0; i < shapes.size(); i++) {
                    if ((shapes.get(i)).contains(e.getPoint())) {
                        shapes.get (i).setColor (shapeColor);
                        repaint();
                    }
                }
            }
        }
        if (toolType.equals("delete")) {
            if (shapes.size() > 0) {
                for (int i = 0; i < shapes.size(); i++) {
                    if ((shapes.get(i)).contains(e.getPoint())) {
                        shapes.remove(i);
                        repaint();
                    }
                }
            }
        }

        if (toolType.equals("zoomin")) {
            if (shapes.size() > 0) {
                for (int i = 0; i < shapes.size(); i++) {
                    if ((shapes.get(i)).contains(e.getPoint())) {
                        shapes.get(i).resize(0.5);
                        repaint();
                    }
                }
            }
        }
        if (toolType.equals("zoomout")) {
            if (shapes.size() > 0) {
                for (int i = 0; i < shapes.size(); i++) {
                    if ((shapes.get(i)).contains(e.getPoint())) {
                        shapes.get(i).resize(-0.5);
                        repaint();
                    }
                }
            }
        }
    }


    public void mouseDragged(MouseEvent e) {

        if (toolType.equals(Shape.pencil)) {
            currentPen.add(e.getPoint());
            repaint();
        }
    }


    public void mouseMoved(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        index++;
        if (toolType.equals(Shape.circle)) {
            Circle circle = new Circle( shapeColor, toolType,startPoint, endPoint);
            shapes.add(circle);
        } else if (toolType.equals(Shape.line)) {
            Line line = new Line(shapeColor, toolType,startPoint, endPoint);
            shapes.add(line);
        } else if (toolType.equals(Shape.rect)) {
            Rect rectangle = new Rect( shapeColor, toolType,startPoint, endPoint);
            shapes.add(rectangle);
        } else if (toolType.equals(Shape.pencil)) {
            currentPen.add(e.getPoint());
            FreeFormLine freeFormLine = new FreeFormLine(shapeColor, toolType, currentPen);
            shapes.add(freeFormLine);
            currentPen = null;
        } else if ((toolType.equals("cursor"))) {

        }
        repaint();
    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }


    public void setToolType(String tool) {
        toolType = tool;
    }

    public static void setShapeColor(Color color) {
        shapeColor = color;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> DBshapes) {
        shapes = DBshapes;
        index = DBshapes.size();
        repaint();
    }

    public void clear() {
        shapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(69, 69, 69));
        g2d.fillRect(1, 1, this.getWidth(), getHeight());
        if (startPoint != null && endPoint != null) {
            if (!shapes.isEmpty()) {
                for (int i = 0; i < shapes.size(); i++) {

                    g2d.setColor(shapes.get(i).getColor());
                    g2d.setStroke(new BasicStroke(3));
                    shapes.get(i).draw(g);
                }
            }

            g2d.setColor(shapeColor);
            if (currentPen != null && currentPen.size() > 1) {
                Point p1 = currentPen.get(0);
                for (int i = 1; i < currentPen.size(); i++) {
                    Point p2 = currentPen.get(i);
                    int x1 = p1.x;
                    int y1 = p1.y;
                    int x2 = p2.x;
                    int y2 = p2.y;
                    g.drawLine(x1, y1, x2, y2);
                    p1 = p2;
                }
            }


        }
    }
}


