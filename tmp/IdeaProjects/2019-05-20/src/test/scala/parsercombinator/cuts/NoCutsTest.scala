package parsercombinator.cuts

import org.scalatest.FlatSpec

class NoCutsTest extends FlatSpec {

  "No cuts test" should "pass" in {
    val noCuts = new NoCuts()
    val (value, successIndex) = noCuts.pass("val abcd")
    assert(value == "abcd")
    assert(successIndex == 8)
  }

  "StringIn test" should "fail" in {
    val noCuts = new NoCuts()
    val (f, label, index, extra, trace) = noCuts.fail("val 1234")
    assert(label == "")
    assert(index == 0)
//                              println(f.msg)
    assert(f.msg == "Position 1:1, found \"val 1234\"")
//    println(trace)
    assert(trace == "Expected nocut:1:1 / (\"val \" ~ alpha.rep(1) | \"def \"):1:1, found \"val 1234\"")
  }


}
