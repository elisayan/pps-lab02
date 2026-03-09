package it.unibo.pps.u02

object es2 extends App {

  //point 3 a
  println("Point 3a:")
  val x = -2
  val res = x match {
    case pos if x > 0 => "x is positive"
    case _ => "x is negative"
  }
  println(res)

  //point 3 b
  println("Point 3b: ")

  def neg(p: String => Boolean): String => Boolean = s => !p(s)

  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = neg(empty) // which type of notEmpty?
  println(notEmpty("foo")) // true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test

  //point 4
  println("Point 4: ")
  print("p1: ")
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  print(p1(1)(2)(3).toString + " ")
  println(p1(1)(2)(2))

  print("p2: ")
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  print(p2(1, 2, 3).toString + " ")
  println(p2(1, 2, 2))

  print("p3: ")

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  print(p3(1)(2)(3).toString + " ")
  println(p3(1)(2)(2))

  print("p4: ")

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  print(p4(1, 2, 3).toString + " ")
  println(p4(1, 2, 2))
}
