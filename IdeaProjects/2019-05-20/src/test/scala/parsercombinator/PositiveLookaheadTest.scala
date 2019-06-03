package parsercombinator

import org.scalatest.FlatSpec

class PositiveLookaheadTest extends FlatSpec {

  "Positive lookahead" should "pass1" in {
    val positive = new PositiveLookahead()
    val (value, successIndex) = positive.pass1("hello ")
    assert(value == Seq("hello"))
    assert(successIndex == 5)
  }

  it should "pass2" in {
    val positive = new PositiveLookahead()
    val (value, successIndex) = positive.pass1("helloX")
    assert(value == Seq())
    assert(successIndex == 0)
  }

}
