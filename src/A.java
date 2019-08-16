import static java.util.Arrays.*;

import java.util.Arrays;

class A {

  public boolean exists(int[] ints, int k) {
    Boolean ret = null;
    for (int i = 0; i < ints.length; i++) {
    if (ints[i] == k) {
      return ret = true;
    } else {
      ret = false;
    }
  }
    return ret;
}

  public boolean existsBin(int[] ints, int k) {
    int[] sortInts = ints;
    Arrays.sort(sortInts);
    if(binarySearch(sortInts,k) == 1){
      return true;
    }
    return false;
  }
}


