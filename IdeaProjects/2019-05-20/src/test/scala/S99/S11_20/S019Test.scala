package S99.S11_20

import org.scalatest.FlatSpec

class S019Test extends FlatSpec {

  "S019: Rotate a list N places to the left." should "work" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    assert(S019.rotate(3, list) == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
  }

}
