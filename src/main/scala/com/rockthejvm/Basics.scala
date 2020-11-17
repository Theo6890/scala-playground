package com.rockthejvm

object Basics extends App {
  // Defining a value = const
  // Int not needed compiler find it on its own
  val meaningOfLife = 42
  // Types always take a Maj cause EVERYTHING is an object in Scala
  val aBool: Boolean = true

  val interpolatedString = s"The meaning of life is $meaningOfLife"
  // Expression = strf-expression
  val ifExp = if (meaningOfLife > 43) 56 else 999
  val chainedIfExp = {
    if (meaningOfLife > 42) 56
    else if (meaningOfLife < 0) -2
    else 0
  }

  // Code block
  val codeBlock = {
    // Definition
    val aLocalVal = 67

    // Value of block is last expression
    aLocalVal + 3
  }

  // Define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // Define a recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /*
    factorial(3) = 3 * factorial(2) = 3 * 2
    factorial(2) = 2 * factorial(1) = 2 * 1
    factorial(1) = 1
    factorial(0) = 1
  */

  // In Scala we don't use loops or iteration, we use RECURSION!
  // Think in term of function and recursion

  // Unit type = no meaningful value === void in other language
  // type of SIDE EFFECTS
  println("I love Scala")

  def myUnitReturningFunction(): Unit = {
    print("I hate returning Unit")
  }
}
