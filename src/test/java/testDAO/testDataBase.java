package testDAO;

import static DAO.IOmanager.*;

import model.Line;
import model.Shape;
import model.User;
import org.dom4j.io.SAXContentHandler;
import org.junit.*;
import org.junit.Assert.*;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;

public class testDataBase {
        private User user;
    @Before
    public  void setup(){

        try {
            open();
        }catch (Exception e){
        }
    }
    @Test
    public void testInsertUser() throws Exception {
        user=new User("reza","1234");
        addUser(user);
    }
    @Test
    public void testExist() throws Exception{
        Assert.assertNotNull(getUser("alireza"));
         user=getUser("alireza");
        Assert.assertEquals("1234",user.getPassword());
    }
    @Test
    public void  testInsertShape() throws Exception{
        ArrayList<Shape> shapes=new ArrayList<Shape>();
        Line line= new Line(new Color(244),"Line",new Point(100,100),new Point(200,200));
        shapes.add(line);
        insertShapes(shapes);
    }
    @After
    public void tearDown() {
        try {
            getTransaction().rollback();
            getSession().close();
        }catch (Exception e){
        }
    }
}
