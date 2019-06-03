package parsercombinator

import org.scalatest.FlatSpec

class SequenceTest extends FlatSpec {

  "Sequence Test" should "pass1" in {
    val sequence = new Sequence()
    val (value, successIndex) = sequence.parseSequence("ab")
    assert(value == ())
    assert(successIndex == 2)
  }

  it should "fail1" in {
    val sequence = new Sequence()
    val (f, label, index, extra) = sequence.parseSequenceFail("aa")
    assert(label == "")
    assert(index == 1)
//    println(f.msg)
    assert(f.msg == "Position 1:2, found \"a\"")
  }

}
