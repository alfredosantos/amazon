import org.junit.Test;

class Solution {
  public int solution(int[] A) {
    // write your code in Java SE 8
    int N = A.length;
    int[] C = new int[N];
    /*
     * Mark A[i] as visited by making A[A[i] - 1] negative
     * */
    for (int i = 0; i < N; i++) {

      /*
       * we need the absolute value for the duplicates
       * */
      int j = Math.abs(A[i]) - 1;

      if (j >= 0 && j < N && A[j] > 0) {
        C[j] = -A[j];
      }
    }

    for (int i = 0; i < N; i++) {
      if (C[i] == 0) {
        return i + 1;
      }
    }
    return N + 1;
  }

  @Test
  public void solution() {
    int[][] arrays = new int[][]{{1,-1,-5,-3,3,4,2,8},
        {5, 4, 3, 2, 1},
        {0, 3, -2, -1, 1}};

    for (int i = 0; i < arrays.length; i++) {
      System.out.println(solution(arrays[i]));
    }
  }
}
//  Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//    Given A = [1, 2, 3], the function should return 4.
//
//    Given A = [−1, −3], the function should return 1.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].