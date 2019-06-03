package parsercombinator

import org.scalatest.FlatSpec

class CharInTest extends FlatSpec {

  "ci test" should "pass" in {
    val charIn = new CharIn()
    val (value, successIndex) = charIn.ciPass("aaabbccxyz")
    assert(value == "aaabbccxyz")
    assert(successIndex == 10)
  }

  it should "fail" in {
    val charIn = new CharIn()
    val (f, label, index, extra) = charIn.ciFail("aaabbccdxyz")
    assert(label == "")
    assert(index == 7)
    //                      println(f.msg)
    assert(f.msg == "Position 1:8, found \"dxyz\"")
  }

  "digits test" should "pass" in {
    val charIn = new CharIn()
    val (value, successIndex) = charIn.digitsPass("12345abcde")
    assert(value == "12345")
    assert(successIndex == 5)
  }

  it should "pass2" in {
    val charIn = new CharIn()
    val (value, successIndex) = charIn.digitsPass("123abcde45")
    assert(value == "123")
    assert(successIndex == 3)
  }

}
