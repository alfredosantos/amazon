import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class Codingame {
  @Test
  public void Test1() {
    A a = new A();
    int[] ints = {-9, 14, 37, 102};
    Assert.assertTrue(a.existsBin(ints, 14));
  }

  @Test
  public void Test2() {
    A a = new A();
    int[] ints = {-9, 14, 37, 102};
    Assert.assertTrue(a.existsBin(ints, 14));
    Assert.assertFalse(a.existsBin(ints, -6));
  }
}
