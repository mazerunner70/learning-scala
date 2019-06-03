package parsercombinator

import org.scalatest.FlatSpec

class StringInTest extends FlatSpec {

  "StringIn test" should "pass" in {
    val stringIn = new StringIn()
    val (value, successIndex) = stringIn.pass("cowcattle")
    assert(value == Seq("cow", "cattle"))
    assert(successIndex == 9)
  }

  it should "pass2" in {
    val stringIn = new StringIn()
    val (value, successIndex) = stringIn.pass("cowmoo")
    assert(value == Seq("cow"))
    assert(successIndex == 3)
  }

  it should "fail" in {
    val stringIn = new StringIn()
    val (f, label, index, extra) = stringIn.fail("co")
    assert(label == "")
    assert(index == 0)
//                          println(f.msg)
    assert(f.msg == "Position 1:1, found \"co\"")
  }

}
