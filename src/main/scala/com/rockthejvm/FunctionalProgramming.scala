package com.rockthejvm

object FunctionalProgramming extends App {

  class Person(name: String) {
    def apply(age: Int) = println(s"I'm $age")
  }

  val bob = new Person("Bob")
  //  bob.apply(43)
  bob(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass function as args
    return function as results

    Conclusion: FunctionX = Function1, Function 2, .. Function22 (22 max args)
   */
  // One argument & one return type
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  //  simpleIncrementer.apply(23)
  simpleIncrementer(23) // same as above due to apply

  // ALL Scala functions are instances of these Function_X types

  // Function with 2 arguments and a String return se this instead of Function_X
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(stringConcatenator("I love", "Scala"))

  // Syntax sugars
  // Instead of: doubler = new Function1[Int, Int]...
  // OR
  // doubler: Int => Int = (x:Int) =>
  val doubler = (x: Int) => 2 * x

  // Higher-order functions: function that takes/returns functions
  // Instead of: map(i => i + 1)
  val aMappedList: List[Int] = List(1, 2, 3).map(_ + 1)
  println(aMappedList)
  val flatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  } // alternative syntax of: flatMap(x => List(x, 2 * x))
  println(flatMappedList)
  val filtered = List(1, 2, 3, 4, 5).filter(_ <= 3)

  // All pairs between the numbers 1,2,3 and a,b,c
  val allPairs = List(1, 2, 3).flatMap { nbr =>
    List('a', 'b', 'c').map { letter =>
      s"$nbr-$letter"
    }
  }
  println(allPairs)

  // For comprehensions alternative
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter" // equivalent as map/flatMap
  println(alternativePairs)


  /**
   * Collections
   */
  val aList = List(1, 2, 3, 4, 5)
  val firstElem = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // add 0 --> List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // add 0 & 6 --> List(0,1,2,3,4,5,6)

  // Sequences
  val aSeq: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3
  val accessedElement = aSeq(1) // element a index 1 : returns 2

  // Vector: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  // Sets: no duplicates
  val aSet = Set(1,2,3,4,1,2)
  val setHas5 = aSet.contains(5)
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5) no especially in this order
  val aRemovedSet = aSet - 3 // Set(1,2,4,5) no especially in this order

  // Range
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(_ * 2).toList // List(2, 4, 6, ... 2000)

  // Tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // Maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 643654),
    "Jane" -> 33243 // same as above
  )

}
