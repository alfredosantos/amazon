package com.alfredo;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestMovile {
  @Test
  public void TestMovileUser() {
    Movile movile = new Movile();
    List<String> listIntegers = Arrays.asList("john", "john", "tom", "john");
    Assert.assertEquals(listIntegers, movile.usernamesSystem(listIntegers));
  }
}
