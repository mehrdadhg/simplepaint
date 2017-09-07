package view;

import DAO.JDBCmanager;
import DAO.IOmanager;
import logic.PassEncryption;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame{

    public static final int height=500;
    public static final int width=660;
    private static LoginPanel loginPanel;
    private JPanel uNamePanel;
    private JPanel passPanel;
    private JPanel btnPanel;
    private JLabel uNameLabel=new JLabel ("username:");
    private JTextField uNameTextField=new JTextField (25);
    private JLabel passLabel=new JLabel ("password:");
    private JPasswordField passwordField=new JPasswordField (25);
    private JButton loginButton=new JButton ("login");
    private JButton registerButton=new JButton ("register");
    private JCheckBox showPasswordCheckBox=new JCheckBox ("show password",true);
    public User sysUser;


    public LoginPanel(){
        final LoginPanel loginPanel=this;
        this.setBounds (330,100,width,height);
        this.setTitle ("simple paint ^_^");
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setLayout (new GridLayout (3,0));
        uNamePanel=new JPanel ();
        uNamePanel.add (uNameLabel);
        uNamePanel.add (uNameTextField);
        passPanel=new JPanel ();
        passPanel.add (passLabel);
        passPanel.add (passwordField);
        passPanel.setBackground (Color.LIGHT_GRAY);
        btnPanel=new JPanel ();
        btnPanel.add (loginButton);
        btnPanel.add (registerButton);

        this.add (uNamePanel);
        this.add (passPanel);
        this.add (btnPanel);
        this.add (showPasswordCheckBox);

        this.setVisible (true);
        registerButton.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                if (uNameTextField.getText ().trim ().equals ("") || passwordField.getText ().trim ().equals (""))
                    JOptionPane.showMessageDialog (null, "username and password field must be filled");
                else {
                    IOmanager.open();
                    if(IOmanager.getUser (uNameTextField.getText ())==null) {
                        try {
                            IOmanager.addUser(new User(uNameTextField.getText(), PassEncryption.getDigest(passwordField.getText())));
                            JOptionPane.showMessageDialog(null, "registered successfully");
                        }catch (Exception ed){

                        }
                    }
                    else JOptionPane.showMessageDialog (null,"this username is not available");
                }
            }
        });
        showPasswordCheckBox.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                if (showPasswordCheckBox.isSelected ())
                    passwordField.setEchoChar ('*');
                else
                    passwordField.setEchoChar ((char) 0);
            }

        });
        loginButton.addActionListener (new ActionListener () {
            public void actionPerformed (ActionEvent e) {

                if (uNameTextField.getText ().trim ().equals ("") || passwordField.getText ().trim ().equals (""))
                    JOptionPane.showMessageDialog (null, "username and password field must be filled");
                else {
                    IOmanager.open();
                    if(IOmanager.getUser (uNameTextField.getText ())!=null) {
                        try {
                            if (IOmanager.getUser(uNameTextField.getText()).getPassword().equals(PassEncryption.getDigest(passwordField.getText()))) {
                                JOptionPane.showMessageDialog(null, "you're login successfully");
                                sysUser = IOmanager.getUser(uNameTextField.getText());
                                new MainFrame(loginPanel).drawPanel.setShapes(JDBCmanager.getShapes(sysUser));
                            }
                        }catch (Exception es){

                        }
                    }
                    else JOptionPane.showMessageDialog (null,"username or password is wrong");
                }
            }
        });

    }

    public static void main (String[] args) {
       loginPanel =new LoginPanel ();
    }
}
