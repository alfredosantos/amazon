import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestSolution {
    // write your code in Java SE 8
    @Test
    public void testGetFirstSmallestPositiveNumber() {
      int[] arrays = {1,9,8,7,6,4,2,3};
      Solution solution = new Solution();
      for (int i = 0; i < arrays.length; i++) {
        System.out.println(solution.solution(arrays));
      }
    }

  @Test
  public void TestFindArray() {
    FindIntArray findIntArray = new FindIntArray();
    Assert.assertEquals(23, findIntArray.solution(53, 195378678));
  }

  @Test
  public void TestFindNumber() {
    FindIntArray findNumber = new FindIntArray();
    List<Integer> listIntegers = Arrays.asList(1, 10, 5, 0);
    Assert.assertEquals("YES", findNumber.findNumber(listIntegers, 5));
  }
}

