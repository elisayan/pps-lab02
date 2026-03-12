package it.unibo.pps.u02

import org.junit.*
import org.junit.Assert.*
import it.unibo.pps.u02.Lab2.*

class ExprTest {

  val v1 = 10
  val v2 = 5
  val v3 = 2

  @Test def literalShouldEvaluateToItsValue(): Unit =
    val e = Expr.Literal(v1)
    assertEquals(v1, evaluate(e))

  @Test def additionShouldEvaluateCorrectly(): Unit =
    val e = Expr.Add(Expr.Literal(v1), Expr.Literal(v2))
    assertEquals(v1 + v2, evaluate(e))

  @Test def multiplicationShouldEvaluateCorrectly(): Unit =
    val e = Expr.Multiply(Expr.Literal(v1), Expr.Literal(v3))
    assertEquals(v1 * v3, evaluate(e))

  @Test
  def showShouldFormatAdditionCorrectly(): Unit =
    val e = Expr.Add(Expr.Literal(v1), Expr.Literal(v2))
    assertEquals(s"($v1 + $v2)", show(e))

  @Test
  def complexExpressionShouldEvaluateCorrectly(): Unit =
    val e = Expr.Multiply(
      Expr.Add(Expr.Literal(v1), Expr.Literal(v2)),
      Expr.Literal(v3)
    )
    assertEquals((v1 + v2) * v3, evaluate(e))
}
