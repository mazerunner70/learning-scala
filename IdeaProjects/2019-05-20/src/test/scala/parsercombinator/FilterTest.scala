package parsercombinator

import org.scalatest.FlatSpec

class FilterTest extends FlatSpec {

  "Filter Test" should "pass1" in {
    val filter = new Filter()
    val (value, successIndex) = filter.pass("12")
    assert(value == 12)
    assert(successIndex == 2)
  }

  it should "fail1" in {
    val filter = new Filter()
    val (f, label, index, extra)= filter.fail("123")
    assert(label == "")
    assert(index == 3)
//              println(f.msg)
    assert(f.msg == "Position 1:4, found \"\"")
  }

}
