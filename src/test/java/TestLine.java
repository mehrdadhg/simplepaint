
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class TestLine {
    private static Line line;
    private static final Logger logger = LogManager.getLogger(TestCircle.class.getName());
    @BeforeClass
    public static void startup(){
        line=new Line();
        logger.info("object Line created");
    }
    @Test
    public void testLine(){
        line.setStartPoint(new Point(101,100));
        line.setEndPoint(new Point(200,100));
        Boolean b=line.contains(new Point(100,150));
        Assert.assertFalse(b);
        logger.trace("test Line was"+b);
    }

}
