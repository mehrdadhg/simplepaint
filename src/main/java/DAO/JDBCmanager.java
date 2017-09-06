package DAO;

import model.Circle;
import model.Line;
import model.Rect;
import model.Shape;
import model.User;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCmanager {

    public static ArrayList<Shape> getShapes(User user) {
        ArrayList<model.Shape> shapes = new ArrayList<model.Shape>();
        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shapes", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shapes where user_id=" + user.getId() + ";");
            while (rs.next()) {
                if (rs.getString("type").equals("line"))
                    shapes.add(new Line(rs.getInt("rgb"), rs.getString("type"), rs.getInt("x1"), rs.getInt("x2"),  rs.getInt("y1"),rs.getInt("y2")));
                if (rs.getString("type").equals("rect"))
                    shapes.add(new Rect(rs.getInt("rgb"), rs.getString("type"), rs.getInt("x1"), rs.getInt("x2"),  rs.getInt("y1"),rs.getInt("y2")));
                if (rs.getString("type").equals("circle"))
                    shapes.add(new Circle(rs.getInt("rgb"), rs.getString("type"), rs.getInt("x1"), rs.getInt("x2"),  rs.getInt("y1"),rs.getInt("y2")));
            }

        } catch (Exception e) {

        }
        return shapes;
    }

    public static void insertShapes(ArrayList<model.Shape> shapes, User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shapes", "root", "");
            Statement stmt = conn.createStatement();
            if(shapes.isEmpty())
                stmt.executeUpdate("truncate shapes");
            else {
                for (int i = 0; i < shapes.size(); i++) {
                    stmt.executeUpdate("insert into shapes(x1,y1,x2,y2,type,rgb,user_id) values (" + shapes.get(i).getStartPoint().x + "," + shapes.get(i).getStartPoint().y + "," + shapes.get(i).getEndPoint().x + "," + shapes.get(i).getEndPoint().y + ",'" + shapes.get(i).getType() + "'," + shapes.get(i).getRgb() + "," + user.getId() + ");");
                }
            }
        } catch (Exception e) {

        }
    }

    public static boolean isExist(String uName) {

        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shapes", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where username='" + uName + "';");
            if (rs.next())
                return true;
        } catch (Exception e) {

        }
        return false;
    }

    public static User getUser(String uName, String pass) {

        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shapes", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where username='" + uName + "' and password='" + pass + "';");
            if (rs.next())
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
        } catch (Exception e) {

        }
        return null;
    }

    public static void addUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getInterfaces();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shapes", "root", "");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into users(username,password) values('" + user.getuName() + "','" + user.getPassword() + "');");
        } catch (Exception e) {

        }
    }
}
