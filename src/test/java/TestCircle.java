
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class TestCircle {
    private static  Logger logger =null;
    private static Circle circle;

  /*  @BeforeClass
    public static void setLogger() {
        System.setProperty("log4j.configurationFile","log4j2.xml");
        logger = LogManager.getLogger();
    }*/

    @BeforeClass
    public static void startup(){
        circle=new Circle();
       // logger.info("circle created");
    }
    @Test
    public void testCircle(){
        circle.setStartPoint(new Point(101,100));
        circle.setEndPoint(new Point(200,100));
        Boolean b=circle.contains(new Point(200,100));
        Assert.assertTrue(b);
   //    logger.trace("test circle was"+b);
    }
}
