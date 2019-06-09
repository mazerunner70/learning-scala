package S99.S1_10

import org.scalatest.FlatSpec

class S007Test extends FlatSpec {

  "S007 - flatten a list structure." should "work" in {
    val list = List(List(1, 1), 2, List(3, List(5, 8)))
    assert(S007.flatten_b(list) == List(1, 1, 2, 3, List(5, 8)))
    assert(S007.flatten_nested_b(list) == List(1, 1, 2, 3, 5, 8))
    assert(S007.flatMap_flatten_b(list) == List(1, 1, 2, 3, List(5, 8)))
    assert(S007.flatMap_flatten_nested_b(list) == List(1, 1, 2, 3, 5, 8))
  }


}
