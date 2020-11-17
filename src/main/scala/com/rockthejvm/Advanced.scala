package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  /**
   * Lazy evaluation
   */
  // Lazy evaluation: not evaluated til it's used
  // Useful in infinite collection
  lazy val aLazyVal = 2
  lazy val lazyValueWithSideEffect = {
    println("I'm so lazy")
    43
  } // Doesn't do anything while it's not called

  val eager = lazyValueWithSideEffect + 1 // Will trigger lazyValueWithSideEffect


  /**
   * Pseudo-collections: Option, Try
   */
  def methodCanReturnNull(): String = "hello, Scala"

  // get rid off of: if(methodCanReturnNull() == null)
  val anOption = Option(methodCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at MOST one element: above or None (Singleton & generic value)

  val stringProcess = anOption match {
    case Some(string) => s"I have obtained: $string"
    case None => "Obtained nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException

  // Get rid off try/catch bloc
  val aTry = Try(methodWhichCanThrowException()) // return a value or ex wrapped by a "collection"
  val anotherStringProcess = aTry match {
    case Success(validValue) => s"I've obtained: $validValue"
    case Failure(ex) => s"I've obtain exception: $ex"
  }


  /**
   * Evaluate something on another thread (async prog)
   */
  val aFuture = Future { // Future.apply and avoid wrapping ({}), only {}
    println("Loading...")
    Thread.sleep(1000)
    println("I've computed a value")
    67
  } // need: import scala.concurrent.ExecutionContext.Implicits.global
  // Future is a "collection" which contains a value when it has been evaluated
  // Future is composable with map, flatMap and filter


  /**
   * Implicits basics: Use it carefully
   */
  // #1: Implicit args
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt) --> 47

  // #2: Implicit conversion
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven()
}
