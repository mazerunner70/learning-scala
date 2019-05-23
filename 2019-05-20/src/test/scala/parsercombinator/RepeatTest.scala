package parsercombinator

import org.scalatest.FlatSpec

class RepeatTest extends FlatSpec {

  "repeated element" should "show success1" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.simpleRep("aaaaaaab")
    assert(value == ())
    assert(successIndex == 8)
  }

  "repeated element" should "show success2" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.simpleRep("aaaaba")
    assert(value == ())
    assert(successIndex == 5)
  }

  "separator reps" should "show success1" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.separatorRep("ababababac")
    assert(value == ())
    assert(successIndex == 10)
  }

  "separator reps" should "show fail1" in {
    val repeat = new Repeat()
    val (f, label, index, extra)= repeat.separatorRepFail("abaabac")
    assert(label == "")
    assert(index == 3)
    assert(f.msg == "Position 1:4, found \"abac\"")
  }

  "separator 4 reps" should "show success1" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.separator4Rep("ababababababa")
    assert(value == ())
    assert(successIndex == 7)
  }

  "separator 4 reps" should "show success2" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.separator4Rep("abababa")
    assert(value == ())
    assert(successIndex == 7)
  }

  "separator 4 reps" should "show fail1" in {
    val repeat = new Repeat()
    val (f, label, index, extra)= repeat.separator4RepFail("ab")
    assert(label == "")
    assert(index == 2)
//    println(f.msg)
    assert(f.msg == "Position 1:3, found \"\"")
  }

  "separator 2 exactly reps" should "show success1" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.separator2ExactRep("abababab")
    assert(value == ())
    assert(successIndex == 4)
  }

  "separator ab4c" should "show fail1" in {
    val repeat = new Repeat()
    val (f, label, index, extra)= repeat.separatorAb4cRepFail("ac")
    assert(label == "")
    assert(index == 1)
//    println(f.msg)
    assert(f.msg == "Position 1:2, found \"c\"")
  }

  "separator ab4c" should "show success1" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.separatorAb4cRep("abac")
    assert(value == ())
    assert(successIndex == 4)
  }

  "separator ab4c" should "show success2" in {
    val repeat = new Repeat()
    val (value, successIndex) = repeat.separatorAb4cRep("abababac")
    assert(value == ())
    assert(successIndex == 8)
  }

  "separator ab4c" should "show fail2" in {
    val repeat = new Repeat()
    val (f, label, index, extra)= repeat.separatorAb4cRepFail("ababababac")
    assert(label == "")
    assert(index == 7)
    assert(f.msg == "Position 1:8, found \"bac\"")
  }



}
