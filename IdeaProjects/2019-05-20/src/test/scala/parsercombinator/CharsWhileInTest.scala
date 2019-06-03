package parsercombinator

import org.scalatest.FlatSpec

class CharsWhileInTest extends FlatSpec {

  "charsWhileIn test" should "pass1" in {
    val charsWhileIn = new CharsWhileIn()
    val (value, successIndex) = charsWhileIn.pass("12345")
    assert(value == "12345")
    assert(successIndex == 5)
  }

  it should "pass2" in {
    val charsWhileIn = new CharsWhileIn()
    val (value, successIndex) = charsWhileIn.pass("123 45")
    assert(value == "123")
    assert(successIndex == 3)
  }

}
