package it.unibo.pps.u02

object Lab2 extends App {
  //Task 1
  def divide(x: Double, y: Double): Double = x / y

  def divideCurried(x: Double)(y: Double): Double = x / y

  println(divide(4, 2))
  println(divideCurried(4)(2))

  //Task 2
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

  //point 5
  print("Point 5: ")

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  println(compose(_ - 1, _ * 2)(5)) // 9

  //Task 3
  def power(base: Double, exponent:Int) : Double = exponent match {
    case positive if exponent > 0 => base * power(base, exponent - 1)
    case 0 => 1.0
  }

  println("Results power: ")
  println(power(2,3))
  println(power(5, 2))

  def power_tail (base: Double, exponent : Int) : Double = {
    def loop (res: Double, e: Int): Double = e match {
      case positive if e > 0 => loop(res * base, e-1)
      case 0 => res
    }
    loop(1.0, exponent)
  }

  println("Results power with tail recursion: ")
  println(power(2, 3))
  println(power(5, 2))

}
