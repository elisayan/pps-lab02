package it.unibo.pps.u02

import it.unibo.pps.u02.Lab2.Expr.{Add, Literal, Multiply}

object Lab2 extends App {
  //Task 1
  println("Task 1:")

  println("Hello World")

  def divide(x: Double, y: Double): Double = x / y

  def divideCurried(x: Double)(y: Double): Double = x / y

  println(divide(4, 2))
  println(divideCurried(4)(2))

  //Task 2
  println("\nTask 2:")
  //point 3 a
  println("Point 3a:")
  val x = -2
  val res = x match
    case pos if x > 0 => "x is positive"
    case _ => "x is negative"

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
  println("\nTask 3:")

  def power(base: Double, exponent: Int): Double = exponent match
    case positive if exponent > 0 => base * power(base, exponent - 1)
    case 0 => 1.0

  println("Results power: ")
  println(power(2, 3))
  println(power(5, 2))

  def power_tail(base: Double, exponent: Int): Double =
    def loop(res: Double, e: Int): Double = e match
      case positive if e > 0 => loop(res * base, e - 1)
      case 0 => res

    loop(1.0, exponent)


  println("Results power with tail recursion: ")
  println(power(2, 3))
  println(power(5, 2))

  def reverseNumber(n: Int): Int =
    def getDigit(n: Int, res: Int): Int = n match
      case 0 => res
      case _ => getDigit(n / 10, res * 10 + n % 10)

    getDigit(n, 0)


  println("Reversion number: ")
  println(reverseNumber(12345))

  //Task 4
  enum Expr:
    case Literal(v: Int)
    case Add(l: Expr, r: Expr)
    case Multiply(l: Expr, r: Expr)

  def evaluate(e: Expr): Int = e match
    case Literal(v) => v
    case Add(l, r) => evaluate(l) + evaluate(r)
    case Multiply(l, r) => evaluate(l) * evaluate(r)


  def show(e: Expr): String = e match
    case Literal(v) => v.toString
    case Add(l, r) => "(" + show(l) + " + " + show(r) + ")"
    case Multiply(l, r) => "(" + show(l) + " * " + show(r) + ")"

  println("\nTask 4:")
  val example = Multiply(Literal(2), Add(Literal(3), Literal(4)))
  println(show(example) + " = " + evaluate(example))

  //Task 5
  println("\nTask 5:")

  enum OptionalInt:
    case Just(value: Int)
    case Empty()

  // operations (/algorithms)
  object OptionalInt:

    def isEmpty(opt: OptionalInt): Boolean = opt match
      case Empty() => true
      case _ => false

    def orElse(opt: OptionalInt, orElse: Int): Int = opt match
      case Just(a) => a
      case _ => orElse

    def map(opt: OptionalInt)(f: Int => Int): OptionalInt = opt match
      case Just(a) => Just(f(a))
      case _ => Empty()

    def mapInt(opt: OptionalInt)(f: Int => Int): OptionalInt = opt match
      case Just(v) => Just(f(v))
      case _ => Empty()


    def filter(opt: OptionalInt)(p: Int => Boolean): OptionalInt = opt match
      case Just(v) if p(v) => Just(v)
      case _ => Empty()
}
