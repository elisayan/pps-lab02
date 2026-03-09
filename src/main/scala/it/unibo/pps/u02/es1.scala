package it.unibo.pps.u02

//Tasks part 1
object es1 extends App:
  println("Hi")

  def divide(x: Double, y: Double): Double = x / y

  def divideCurried(x: Double)(y: Double): Double = x / y

  println(divide(4, 2))
  println(divideCurried(4)(2))

