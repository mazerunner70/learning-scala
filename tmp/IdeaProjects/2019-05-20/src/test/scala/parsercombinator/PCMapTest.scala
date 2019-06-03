package parsercombinator

import org.scalatest.FlatSpec

class PCMapTest extends FlatSpec {

  "Map" should "pass1" in {
    val pcMap = new PCMap()
    val (value, successIndex) = pcMap.pass1("1100")
    assert(value == "1100")
    assert(successIndex == 4)
  }

  it should "pass2" in {
    val pcMap = new PCMap()
    val (value, successIndex) = pcMap.pass2("1100")
    assert(value == 12)
    assert(successIndex == 4)
  }

}
