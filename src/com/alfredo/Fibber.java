package com.alfredo;

import java.util.HashMap;
import java.util.Map;

public class Fibber {

  private static Map<Integer, Integer> memo = new HashMap<>();

  public static int fib(int n) {

    if (n < 0) {
      throw new IllegalArgumentException(
          "Index was negative. No such thing as a negative index in a series.");

      // base cases
    } else if (n == 0 || n == 1) {
      return n;
    }

    // see if we've already calculated this
    if (memo.containsKey(n)) {
      System.out.printf("grabbing memo[%d]\n", n);
      return memo.get(n);
    }

    System.out.printf("computing fib(%d)\n", n);
    int result = fib(n - 1) + fib(n - 2);

    // memoize
    memo.put(n, result);

    return result;
  }

  public static void main(String args[]) {
    long preTime=System.currentTimeMillis();
    System.out.println("Value of 25th number in fibonacci series->"+fib(25));
    long postTime=System.currentTimeMillis();
    System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
  }
}