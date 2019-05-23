package parsercombinator

import org.scalatest.FlatSpec

class FailuresTest extends FlatSpec {

  "Parse Either" should "fail on no match" in {
    val failures = new Failures()
    val (f, label, index, extra) = failures.matchEitherFail("b")
    assert(label == "")
    assert(index == 1)
    assert(f.msg == "Position 1:2, found \"\"")
  }

  it should "fail demonstrating 3 levels of debug available" in {
    val failures = new Failures()
    val (f, label, index, extra) = failures.matchEitherFail("d")
    assert(label == "")
    assert(index == 0)
    assert(f.msg == "Position 1:1, found \"d\"")
    val trace = f.trace()
    assert(trace.label == "\"c\"")
    assert(trace.index == 0)
    assert(trace.msg == "Expected \"c\":1:1, found \"d\"")
    //println(trace.longMsg)// Use this to get string to test against
    assert(trace.longMsg == "Expected parseA:1:1 / \"c\":1:1, found \"d\"")
  }


}
