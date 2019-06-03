package parsercombinator

import org.scalatest.FlatSpec

class AnyCharTest extends FlatSpec {

  "AnyChar" should "pass" in {
    val anyCh = new AnyChar()
    val (value, successIndex) = anyCh.pass("'-'")
    assert(value == "-")
    assert(successIndex == 3)
  }

  it should "fail" in {
    val anyCh = new AnyChar()
    val (f, label, index, extra)= anyCh.fail("'-='")
    assert(label == "")
    assert(index == 2)
//      println(f.msg)
    assert(f.msg == "Position 1:3, found \"='\"")
  }

}
