package S99.S11_20

import org.scalatest.FlatSpec

class S014Test extends FlatSpec {

  "Test 014: Duplicate the elements of a list." should "work" in {
    val list = List('a, 'b, 'c, 'c, 'd)
    assert(S014.duplicate(list) == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

}
