package parsercombinator.cuts

import org.scalatest.FlatSpec

class CutsTest extends FlatSpec {

  "cuts test" should "pass" in {
    val cuts = new Cuts()
    val (value, successIndex) = cuts.pass("val abcd")
    assert(value == "abcd")
    assert(successIndex == 8)
  }

  "StringIn test" should "fail" in {
    val cuts = new Cuts()
    val (f, label, index, extra, trace) = cuts.fail("val 1234")
    assert(label == "")
    assert(index == 4)
//    println(f.msg)
    assert(f.msg == "Position 1:5, found \"1234\"")
//        println(trace)
    assert(trace == "Expected cut:1:1 / alpha:1:5 / [a-z]:1:5, found \"1234\"")
  }



}
