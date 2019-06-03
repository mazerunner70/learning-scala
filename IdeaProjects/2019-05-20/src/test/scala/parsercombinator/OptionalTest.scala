package parsercombinator

import org.scalatest.FlatSpec

class OptionalTest extends FlatSpec {

  "Optional test" should "succeed1" in {
    val optional = new Optional()
    val (value, successIndex) = optional.demoSuccess("aba")
    assert (value == "aba")
    assert(successIndex == 3)
  }

  "Optional test" should "succeed2" in {
    val optional = new Optional()
    val (value, successIndex) = optional.demoSuccess("caba")
    assert (value == "aba")
    assert(successIndex == 4)
  }

}
