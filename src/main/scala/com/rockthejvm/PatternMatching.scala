package com.rockthejvm

object PatternMatching extends App {
  // Switch expression
  val anInteger = 25
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  } // pattern is an expression

  // CASE CLASSES (only) deconstruction
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43) // Person.apply
  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a yo"
    case _ => "Something else"
  }
  println(personGreeting)

  // Tuples deconstruction
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about!"
  }

  // Lists deconstruction
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contains 2 on its second"
    case _ => "unknown list"
  } // if PatternMatch doesn't match anything, will throw an error (thats why use default)

}
