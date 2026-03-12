package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

/** Task 5: do test for map * */

  @Test def mapIntShouldTransformValueWhenNonEmpty(): Unit =
    val value = 5
    val nonEmpty = OptionalInt.Just(value)
    val expected = OptionalInt.Just(value + 1)
    assertEquals(expected, OptionalInt.mapInt(nonEmpty)(_ + 1))

  @Test def mapIntShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(OptionalInt.Empty(), OptionalInt.mapInt(empty)(_ + 1))

  @Test def filterShouldKeepValueIfPredicateIsTrue(): Unit =
    val value = 5
    val limit = 2
    val nonEmpty = OptionalInt.Just(value)
    assertEquals(OptionalInt.Just(value), OptionalInt.filter(nonEmpty)(_ > limit))

  @Test def filterShouldReturnEmptyIfPredicateIsFalse(): Unit =
    val value = 5
    val limit = 8
    val nonEmpty = OptionalInt.Just(value)
    assertEquals(OptionalInt.Empty(), OptionalInt.filter(nonEmpty)(_ > limit))

  @Test def filterShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(OptionalInt.Empty(), OptionalInt.filter(empty)(_ > 2))