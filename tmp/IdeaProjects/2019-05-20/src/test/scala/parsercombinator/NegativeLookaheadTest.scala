package parsercombinator

import org.scalatest.FlatSpec

class NegativeLookaheadTest extends FlatSpec {

  "Negative Lookahead" should "pass" in {
    val negative = new NegativeLookahead()
    val (value, successIndex) = negative.pass("hello-world")
    assert(value == "hello-world")
    assert(successIndex == 11)
  }

  "Negative Lookahead" should "pass2" in {
    val negative = new NegativeLookahead()
    val (value, successIndex) = negative.pass("hello_world")
    assert(value == "hello_world")
    assert(successIndex == 11)
  }

  "Negative Lookahead" should "fail1" in {
    val negative = new NegativeLookahead()
    val (f, label, index, extra) = negative.fail("hello world")
    assert(label == "")
    assert(index == 5)
//          println(f.msg)
    assert(f.msg == "Position 1:6, found \" world\"")
  }

}
