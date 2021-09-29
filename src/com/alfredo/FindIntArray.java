package com.alfredo;

import java.util.List;

public class FindIntArray {

  public int solution(int A, int B) {
    int b = 0;
    int[] arrayA = Integer.toString(A).chars().map(c -> c - '0').toArray();
    int[] arrayB = Integer.toString(B).chars().map(c -> c - '0').toArray();
    int[] match = new int[arrayB.length];
    StringBuilder concatenated = new StringBuilder();

    for (int i = 0; i < arrayA.length; i++) {
      for (int e = 0; e < arrayB.length; e++) {
        if (arrayA[i] == arrayB[e]) {
          match[b++] = e;
        }
      }
    }

    for (int x = 0; x < match.length; x++) {
      if (match[x] != 0) {
        concatenated.append(Integer.valueOf(match[x]));
      }
    }
    return Integer.valueOf(concatenated.toString());
  }

  public String findNumber(List<Integer> arr, int k) {
    String ret = "";
    for (int i = 0; i < arr.toArray().length; i++) {
      if (arr.get(i).equals(k)) {
         return ret = "YES";
      } else {
         ret = "NO";
      }
    }
    return ret;
  }
}