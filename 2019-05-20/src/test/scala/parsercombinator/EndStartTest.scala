package parsercombinator

import org.scalatest.FlatSpec

class EndStartTest extends FlatSpec {

  "End test" should "pass1" in {
    val endStart = new EndStart()
    val (value, successIndex) = endStart.noEndPass("aaaba")
    assert(value == ())
    assert(successIndex == 4)
  }

  "End test" should "fail1" in {
    val endStart = new EndStart()
    val (f, label, index, extra)= endStart.withEndFail("aaaba")
    assert(label == "")
    assert(index == 4)
//    println(f.msg)
    assert(f.msg == "Position 1:5, found \"a\"")
  }

  "Start test" should "pass1" in {
    val endStart = new EndStart()
    val (value, successIndex) = endStart.startPass("abab")
    assert(value == "abab")
    assert(successIndex == 4)
  }

  "Start test" should "pass2" in {
    val endStart = new EndStart()
    val (value, successIndex) = endStart.startPass("babab")
    assert(value == "babab")
    assert(successIndex == 5)
  }

  "Start test" should "fail1" in {
    val endStart = new EndStart()
    val (f, label, index, extra) = endStart.startFail("abb")
    assert(label == "")
    assert(index == 2)
//        println(f.msg)
    assert(f.msg == "Position 1:3, found \"b\"")
  }



}
