package parsercombinator

import org.scalatest.FlatSpec

class FlatMapTest extends FlatSpec {

  "Flatmap" should "find a simple tag" in {
    val flatMap = new FlatMap()
    val (value, successIndex) = flatMap.pass("<a></a>")
    assert(value == "a")
    assert(successIndex == 7)
  }

  it should "find second simple tag" in {
    val flatMap = new FlatMap()
    val (value, successIndex) = flatMap.pass("<abcdef></abcdef>")
    assert(value == "abcdef")
    assert(successIndex == 17)
  }

}
