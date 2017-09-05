package testModels;

import model.Rect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class TestRect {
    private static Rect rect;
    private static final Logger logger = LogManager.getLogger(TestCircle.class.getName());
    @BeforeClass
    public static void startup(){
        rect=new Rect();
        logger.info("object Rectangle created");
    }
    @Test
    public void testRect(){
        rect.setStartPoint(new Point(100,100));
        rect.setEndPoint(new Point(200,200));
        Boolean b=rect.contains(new Point(100,150));
        Assert.assertTrue(b);
        logger.trace("test Rectangle was"+b);
    }
}
