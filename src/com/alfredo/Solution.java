package com.alfredo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public static void main(String... args) {
    Solution solution = new Solution();
    int[] myA = {1, 12, 42, 70, 36, -4, 43, 15};
    int[] myB = {5, 15, 44, 72, 36, 2, 69, 24};
    solution.doThis(myA, myB);
  }

  private void doThis(int x[], int y[]) {
    if (x.length == 0 || x.length != y.length) {
      throw new RuntimeException("Bad code");
    }
    List<Interval> intervalList = new ArrayList<>();
    for (int i = 0; i < x.length; i++) {
      if (x[i] <= y[i]) {
        intervalList.add(new Interval(x[i], y[i]));
      } // skip other wise
    }
    Set<Interval> nonOverlappingIntervals = new HashSet<>();
    Set<Interval> intervalsOverlapped = new HashSet<>();
    for (int i = 0; i < intervalList.size(); i++) {
      final Interval interval1 = intervalList.get(i);
      for (int j = i + 1; j < intervalList.size(); j++) {
        Interval overlap = interval1.overlap(intervalList.get(j));
        if (overlap != null) {
          nonOverlappingIntervals.add(overlap);
          intervalsOverlapped.add(interval1);
          intervalsOverlapped.add(intervalList.get(j));
        } else {
          nonOverlappingIntervals.add(interval1);
          nonOverlappingIntervals.add(intervalList.get(j));
        }
      }
    }
    intervalsOverlapped.forEach(interval -> {
      nonOverlappingIntervals.remove(interval);
    });
    nonOverlappingIntervals.forEach(interval -> {
      System.out.println(interval.getX() + ", " + interval.getY());
    });
  }
}

class Interval {

  private int x;
  private int y;

  public Interval(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Interval overlap(final Interval otherInterval) {
    /*
    a is in c, d
    b is in c, d
    c is in a, b
    d is in a, b
    return (a >= c && a <= d) || (b >= c && b <= d) || (c >= a && c <= b) || (d >= a && d <= a);
    */
    if (
        this.getX() >= otherInterval.getX() && this.getX() <= otherInterval.getY() ||
            this.getY() >= otherInterval.getX() && this.getY() <= otherInterval.getY() ||
            otherInterval.getX() >= this.getX() && otherInterval.getX() <= this.getY() ||
            otherInterval.getY() >= this.getX() && otherInterval.getY() <= this.getY()) {
      return new Interval(
          getMin(this.getX(), otherInterval.getX()),
          getMax(this.getY(), otherInterval.getY())
      );
    } else {
      return null;
    }
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  private int getMin(int x, int y) {
    return (x >= y ? y : x);
  }

  private int getMax(int x, int y) {
    return (x >= y ? x : y);
  }
}
//  Write a function:
//
//class com.alfredo.Solution { public int solution(int[] com.alfredo.A); }
//
//that, given an array com.alfredo.A of N integers, returns the smallest positive integer (greater than 0) that does not occur in com.alfredo.A.
//
//    For example, given com.alfredo.A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//    Given com.alfredo.A = [1, 2, 3], the function should return 4.
//
//    Given com.alfredo.A = [−1, −3], the function should return 1.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array com.alfredo.A is an integer within the range [−1,000,000..1,000,000].