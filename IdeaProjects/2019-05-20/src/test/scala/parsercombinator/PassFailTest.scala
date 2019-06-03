package parsercombinator

import org.scalatest.FlatSpec

class PassFailTest extends FlatSpec {

  "Pass/Fail" should "pass" in {
    val passFail = new PassFail()
    val (value, successIndex) = passFail.pass("dummy")
    assert(value == ())
    assert(successIndex == 0)
  }

  it should "fail" in {
    val passFail = new PassFail()
    val (f, label, index, extra) = passFail.fail("dummy")
    assert(label == "")
    assert(index == 0)
//            println(f.msg)
    assert(f.msg == "Position 1:1, found \"dummy\"")
  }

}
