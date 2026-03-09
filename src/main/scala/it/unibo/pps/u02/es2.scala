package it.unibo.pps.u02

object es2 extends App {

  //point 3 a
  val x = -2

  val res = x match {
    case pos if x > 0 => "x is positive"
    case _ => "x is negative"
  }
  println(res)

  //point 3 b
  def neg(p: String => Boolean): String => Boolean = s => !p(s)

  val empty: String => Boolean = _ == "" // predicate on strings

  val notEmpty = neg(empty) // which type of notEmpty?
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test

}
