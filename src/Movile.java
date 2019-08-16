import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movile {
  public List<String> usernamesSystem(List<String> u) {
    // Write your code here
    List<String> arrayA = u;
    List<String> arrayB = u;
    List<String> ret = new ArrayList();;
    for (int i = 0; i < u.toArray().length; i++) {
      for (int e = 0; e < u.toArray().length; e++) {
        if (arrayA.get(i) == arrayB.get(e)) {
          if (i>0){
            if (ret.get(i-1) == arrayB.get(e)) {
              StringBuilder nret = new StringBuilder();
              nret.append(1);
              ret.add(i, arrayA.get(i).toString());
            }
          }
        }
      }
    }
      return ret;
    }
  }
