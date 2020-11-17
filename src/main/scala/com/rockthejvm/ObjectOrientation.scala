package com.rockthejvm

object ObjectOrientation extends App {
  //App contains a main so we've got one by extension
  // public static void main(String[] args)

  class Animal {
    val age = 0

    def eat(): Unit = print("I'm eating")
  }

  val anAnimal = new Animal
  anAnimal.eat()

  // Put a val before vars in constructor will create a class field
  class Dog(val name: String) extends Animal {
  }

  val aDog = new Dog("Lassie")
  println(aDog.name)

  // Subtype polymorphism
  val aDeclaredAnim: Animal = new Dog("Hachi")
  aDeclaredAnim.eat() // the most derived method will be called at runtime

  // Abstract class
  abstract class WalkingAnimal {
    val hasLegs = true //by default public (no specific keyw), protected or private
    def walk(): Unit
  }

  // "Interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    // Usually ! used for async
    def !?(thought: String): Unit // Valid method name
  }

  // Single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("eating animal")

    override def !?(thought: String): Unit = println(s"I was think $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // Infix notation, only for methods with ONE arg
  aCroc !? "What if we could fly?"

  // Operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) //equivalent

  // Anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinosaur I can eat prettty much anyx")
  }

  // Singleton object
  object MySingleton { // only instance of MySingleton type
    val mySpecialValue = 53278

    def mySpecialMethod(): Int = 4334

    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // call apply by default

  object Animal { // class + object = companions --> companion object here
    // can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveIndefinitely = Animal.canLiveIndefinitely // "static" fields/methods

  /* case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
  */
  case class Person(name: String, age: Int)

  // may be constructed without instantiation
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some failure msg"
  } finally {
    // execute code no watter what
  }

  // generics
  abstract class MyList[T] {
    // definition or type that depends on type T
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // T = Int here
  val rest = aList.tail

  // Point #1: in Scala we usually operate with IMMUABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
      BENEFITS:
        1) Works miracles in multithreaded/distributed env
        2) helps making sense of the code ("reasoning about")
  */
  // Point #2: Scala is closest to OO ideal
  val reversedList = aList.reverse
}
