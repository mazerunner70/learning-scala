package parsercombinator

import org.scalatest.FlatSpec

class CaptureTest extends FlatSpec {

  "Capture" should "pass 1" in {
    val capture = new Capture()
    val (value, successIndex) = capture.capture1("aaab")
    assert(value == "aaa")
    assert(successIndex == 4)
  }

  "Capture" should "pass 2" in {
    val capture = new Capture()
    val (value, successIndex) = capture.capture2("aaab")
    assert(value == ("aaa", "b"))
    assert(successIndex == 4)
  }

  "Capture" should "pass 3" in {
    val capture = new Capture()
    val (value, successIndex) = capture.capture3("aaabc")
    assert(value == ("aaa", "b", "c"))
    assert(successIndex == 5)
  }

  "Capture" should "pass 4" in {
    val capture = new Capture()
    val (value, successIndex) = capture.capture4("aaab")
    assert(value == (Seq("a", "a", "a"), "b"))
    assert(successIndex == 4)
  }

  "Capture" should "pass 5" in {
    val capture = new Capture()
    val (value, successIndex) = capture.capture5("aaab")
    assert(value == Some("b"))
    assert(successIndex == 4)
  }

}
