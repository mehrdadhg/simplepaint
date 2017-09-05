package testModels;

import model.Circle;
import model.Line;
import model.Rect;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Circle.class, Line.class, Rect.class})
public class TestShapesSuite {
}
