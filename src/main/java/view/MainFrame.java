package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static final int height=800;
    public static final int width=800;
     ToolBox toolBoxes;
     DrawPanel drawPanel;
    LoginPanel loginPanel;
    public MainFrame(LoginPanel loginPanel){
        this.loginPanel=loginPanel;
        this.setBounds (330,100,width,height);
        this.setTitle ("simple paint ^_^");
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setLayout (new FlowLayout ());
        drawPanel=new DrawPanel ();
        toolBoxes=new ToolBox (this);

        this.add (drawPanel);
        this.add (toolBoxes);
        this.setVisible (true);
        loginPanel.setVisible(false);
    }

}
