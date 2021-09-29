package com.alfredo;

abstract class Animal { }

class Dog extends Animal {
  String name;

  /**
   * Creates a new dog with the given name.
   */
  Dog(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }
}

class Cat extends Animal {
  String name;

  /**
   * Creates a new cat with the given name.
   */
  Cat(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }
}

class Application {

  /**
   * @return the name of the given​​​​​​‌​​​‌​​​​​​‌‌​​​​‌​​‌​​​​ animal
   */
  static String getAnimalName(Animal a) {
    String name = null;
    if (a instanceof Dog) {
      name = ((Dog) a).getName();
    } else if (a instanceof Cat) {
      name = ((Cat) a).getName();
    }

    return name;
  }
}