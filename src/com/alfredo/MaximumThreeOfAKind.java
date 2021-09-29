package com.alfredo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Given to integers say A and B. This produces a string containing exactly A count of letter "a"
 * and B count of letter "b", such that there is no sequence of 3 letters of same kind. No where in
 * the string you must get "aaa" or "bbb".
 */
public class MaximumThreeOfAKind {

  public static void main(String... args) {

    int aCount = 4;
    int bCount = 7;

    MaximumThreeOfAKind patternOfMax3 = new MaximumThreeOfAKind();
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
        if (stringBuilder.toString().endsWith("aa")) {
          // if you find already a double, no point appending it, instead go to the middle of the string and offset "bb"
          int index = stringBuilder.indexOf("bb", 0);
          stringBuilder.insert(index + 1, "a");
        } else {
          stringBuilder.append("a");
        }
        aRemainingCount--;
      }
      int maxCountForB = maxRepeatCount();
      for (int i = 0; i < maxCountForB && bRemainingCount > 0; i++) {
        if (stringBuilder.toString().endsWith("bb")) {
          // if you find already a double, no point appending it, instead go to the middle of the string and offset "aa"
          int index = stringBuilder.indexOf("aa", 0);
          stringBuilder.insert(index + 1, "b");
        } else {
          stringBuilder.append("b");
        }
        bRemainingCount--;
      }
    }
    final String output = stringBuilder.toString();
    if (output.contains("aaaa") || output.contains("bbbb")) {
      System.err.println("Badboy found, fix it");
    }
    assert output.length() == aCount + bCount;
    System.out.println(output);
  }

  /**
   * Returns min 1 and max 2
   */
  private int maxRepeatCount() {
    return ThreadLocalRandom.current().nextInt(1, 2 + 1); // min 1, max 2
  }
}