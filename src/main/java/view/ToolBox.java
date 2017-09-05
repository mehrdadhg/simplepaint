package view;

import DAO.JDBCmanager;
import model.Shape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBox extends JPanel{

    private final DrawPanel drawPanel;
    private MainFrame mainFrame;
    JButton lineBtn=new JButton ();
    JButton circleBtn=new JButton ();
    JButton rectBtn=new JButton ();
    JButton penBtn=new JButton ();
    JButton deleteBtn=new JButton();
    JButton zoomInBtn=new JButton();
    JButton zoomOutBtn=new JButton();
    JButton clearBtn=new JButton ();
    JButton selectColorBtn=new JButton ();
    JButton cursorBtn =new JButton ();
    JButton saveBtn=new JButton ();

    public ToolBox(final MainFrame mainFrame){
        super();
        try {
            Image img1 = ImageIO.read(getClass().getResource("/img/cursor.png"));
            Image img2 = ImageIO.read(getClass().getResource("/img/colors.png"));
            Image img3 = ImageIO.read(getClass().getResource("/img/circle.png"));
            Image img4 = ImageIO.read(getClass().getResource("/img/line.png"));
            Image img5 = ImageIO.read(getClass().getResource("/img/rectangle.png"));
            Image img6 = ImageIO.read(getClass().getResource("/img/pencil.png"));
            Image img7 = ImageIO.read(getClass().getResource("/img/eraser.png"));
            Image img8 = ImageIO.read(getClass().getResource("/img/zoomin.png"));
            Image img9 = ImageIO.read(getClass().getResource("/img/zoomout.png"));
            Image img10 = ImageIO.read(getClass().getResource("/img/delete.png"));
            Image img11 = ImageIO.read(getClass().getResource("/img/save.png"));
            cursorBtn.setPreferredSize (new Dimension (60,60));
            cursorBtn.setIcon(new ImageIcon(img1));
            selectColorBtn.setPreferredSize (new Dimension (60,60));
            selectColorBtn.setIcon(new ImageIcon(img2));
            circleBtn.setPreferredSize (new Dimension (60,60));
            circleBtn.setIcon(new ImageIcon(img3));
            lineBtn.setPreferredSize (new Dimension (60,60));
            lineBtn.setIcon(new ImageIcon(img4));
            rectBtn.setPreferredSize (new Dimension (60,60));
            rectBtn.setIcon(new ImageIcon(img5));
            penBtn.setPreferredSize (new Dimension (60,60));
            penBtn.setIcon(new ImageIcon(img6));
            deleteBtn.setPreferredSize (new Dimension (60,60));
            deleteBtn.setIcon(new ImageIcon(img7));

            zoomInBtn.setPreferredSize (new Dimension (60,60));
            zoomInBtn.setIcon(new ImageIcon(img8));
            zoomOutBtn.setPreferredSize (new Dimension (60,60));
            zoomOutBtn.setIcon(new ImageIcon(img9));
            clearBtn.setPreferredSize (new Dimension (60,60));
            clearBtn.setIcon(new ImageIcon(img10));
            saveBtn.setPreferredSize (new Dimension (60,60));
            saveBtn.setIcon(new ImageIcon(img11));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.drawPanel=mainFrame.drawPanel;
        this.setOpaque (true);
        this.setBackground (Color.WHITE);
        this.setPreferredSize (new Dimension (100,MainFrame.height+20));
        this. setLayout (new FlowLayout ());
        this.add (lineBtn);
        this.add (circleBtn);
        this.add (rectBtn);
        this.add (penBtn);
        this.add(deleteBtn);
        this.add(zoomInBtn);
        this.add(zoomOutBtn);
        this.add (selectColorBtn);
        this.add (cursorBtn);
        this.add(clearBtn);
        this.add (saveBtn);

        lineBtn.addActionListener (new ActionListener(){

            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType (model.Shape.line);
            }
        } );

        circleBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType (Shape.circle);
            }
        } );

        rectBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType (model.Shape.rect);
            }
        } );

        penBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType (model.Shape.pencil);
            }
        } );

        clearBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.clear ();
            }
        } );

        cursorBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType ("cursor");
            }
        } );

        deleteBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType ("delete");
            }
        } );

        zoomInBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType ("zoomin");
            }
        } );
        zoomOutBtn.addActionListener (new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                drawPanel.setToolType ("zoomout");
            }
        } );

        selectColorBtn.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                Color newColor = JColorChooser.showDialog(selectColorBtn, "color chooser", Color.red);
                drawPanel.setToolType("color");
                DrawPanel.setShapeColor (newColor);
            }
        });

        saveBtn.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                JDBCmanager.insertShapes (drawPanel.getShapes (),mainFrame.loginPanel.sysUser);
                new LoginPanel ();
                mainFrame.dispose();

            }
        });

    }

}
