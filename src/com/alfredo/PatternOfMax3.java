package com.alfredo;

import java.util.concurrent.ThreadLocalRandom;

public class PatternOfMax3 {

  public static void main(String... args) {
    int aCount = 15;
    int bCount = 15;
    PatternOfMax3 patternOfMax3 = new PatternOfMax3();
    patternOfMax3.doThis(aCount, bCount);
  }

  private void doThis(int aCount, int bCount) {
    if (Math.abs(aCount - bCount) > 3) {
      throw new RuntimeException("not possible");
    }
    StringBuilder stringBuilder = new StringBuilder("");
    int aRemainingCount = aCount;
    int bRemainingCount = bCount;
    while (aRemainingCount > 0 || bRemainingCount > 0) {
      int maxCountForA = maxRepeatCount();
      for (int i = 0; i < maxCountForA && aRemainingCount > 0; i++) {
        stringBuilder.append("a");
        aRemainingCount--;
      }
      int maxCountForB = maxRepeatCount();
      for (int i = 0; i < maxCountForB && bRemainingCount > 0; i++) {
        stringBuilder.append("b");
        bRemainingCount--;
      }
    }
    if (stringBuilder.toString().contains("aaaa") || stringBuilder.toString().contains("bbbb")) {
      System.err.println("Bad boy found, fix it");
    }
    System.out.println(stringBuilder.toString());
  }

  /**
   * Returns min 1 and max 3
   */
  private int maxRepeatCount() {
    return ThreadLocalRandom.current().nextInt(1, 3 + 1);
  }
}