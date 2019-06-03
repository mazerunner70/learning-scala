package parsercombinator

import org.scalatest.FlatSpec

class CharsWhileTest extends FlatSpec {

  "chars while" should "pass" in {
    val charsWhile = new CharsWhile()
    val (value, successIndex) = charsWhile.pass1("12345")
    assert(value == "12345")
    assert(successIndex == 5)
  }

  "chars while" should "pass2" in {
    val charsWhile = new CharsWhile()
    val (value, successIndex) = charsWhile.pass1("123 45")
    assert(value == "123")
    assert(successIndex == 3)
  }

}
