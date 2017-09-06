package testDAO;

import static DAO.IOmanager.*;

import model.*;
import model.Shape;
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
        Shape line= new Line(88,"Line",100,100,200,200);
        Shape circle=new Circle(999,"circle",99,99,999,999);
        Shape rect=new Rect(77,"rect",333,33,33,33);
        shapes.add(line);
        shapes.add(circle);
        shapes.add(rect);
        insertShapes(shapes);
    }

    @Test
    public void testGetShapes(){
        ArrayList<Object> shapes;
        shapes= getShapes(1);
        //Assert.assertEquals(shapes.get(0).getType(),"Line");
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
