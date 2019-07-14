package S99.S21_30

import org.scalatest.FlatSpec

class S025Test extends FlatSpec {

  "S025: Generate a random permutation of the elements of a list." should "work" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f)
    assert(S025.randomPermute(list).length == list.length)
  }

}
