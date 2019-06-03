package parsercombinator

import org.scalatest.FlatSpec

class PcCharPredTest extends FlatSpec {

  "CharPred test" should "pass" in {
    val pcCharPred = new PcCharPred()
    val (value, successIndex) = pcCharPred.pass("ABC.")
    assert(value == "ABC")
    assert(successIndex == 4)
  }

  "CharPred test" should "fail" in {
    val pcCharPred = new PcCharPred()
    val (f, label, index, extra) = pcCharPred.fail("ABc.")
    assert(label == "")
    assert(index == 2)
//                  println(f.msg)
    assert(f.msg == "Position 1:3, found \"c.\"")
  }

}
