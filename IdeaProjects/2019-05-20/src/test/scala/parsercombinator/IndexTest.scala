package parsercombinator

import org.scalatest.FlatSpec

class IndexTest extends FlatSpec {

  "Index" should "always work" in {
    val index = new Index()
    val (value, successIndex) = index.pass("dummy")
    assert(value == 9)
    assert(successIndex == 18)
  }

}
