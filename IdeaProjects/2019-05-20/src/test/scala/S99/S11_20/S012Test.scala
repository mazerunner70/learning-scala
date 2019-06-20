package S99.S11_20

import org.scalatest.FlatSpec

class S012Test extends FlatSpec {

  "S012 - Decode a run-length encoded list." should "work" in {
    val list = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    assert(S012.unpack_fn(list) == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    assert(S012.unpack_flatmap(list) == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

}
