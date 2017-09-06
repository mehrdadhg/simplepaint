package view;

import model.Circle;
import model.FreeFormLine;
import model.Line;
import model.Rect;
import model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class DrawPanel extends JComponent implements MouseListener, MouseMotionListener {

    private Point startPoint = null;
    private Point endPoint = null;
    private ArrayList<model.Shape> shapes = new ArrayList<model.Shape>();
    private int index;
    private ArrayList<Point> currentPen = null;

    private static String toolType = model.Shape.pencil;
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

        if (toolType.equals(model.Shape.pencil)) {
            currentPen = new ArrayList<Point>();
            currentPen.add(e.getPoint());
            //repaint ();
        }
        if (toolType.equals("color")) {
            if (shapes.size() > 0) {
                for (int i = 0; i < shapes.size(); i++) {
                    if ((shapes.get(i)).contains(e.getPoint())) {
                        shapes.get (i).setRgb (shapeColor.getRGB());
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

        if (toolType.equals(model.Shape.pencil)) {
            currentPen.add(e.getPoint());
            repaint();
        }
    }


    public void mouseMoved(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        index++;
        if (toolType.equals(model.Shape.circle)) {
            Circle circle = new Circle( shapeColor.getRGB(), toolType,startPoint.x, endPoint.x,startPoint.y,endPoint.y);
            shapes.add(circle);
        } else if (toolType.equals(model.Shape.line)) {
            Line line = new Line(shapeColor.getRGB(), toolType,startPoint.x, endPoint.x,startPoint.y,endPoint.y);
            shapes.add(line);
        } else if (toolType.equals(model.Shape.rect)) {
            Rect rectangle = new Rect( shapeColor.getRGB(), toolType,startPoint.x, endPoint.x,startPoint.y,endPoint.y);
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

    public ArrayList<model.Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<model.Shape> DBshapes) {
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

                    g2d.setColor(new Color( shapes.get(i).getRgb()));
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


