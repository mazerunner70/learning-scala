package S99.S11_20

import org.scalatest.FlatSpec

class S016Test extends FlatSpec {

  "S016: Drop every Nth element from a list" should "work" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    assert(S016.drop(3, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
    assert(S016.drop_recursive(3, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
    assert(S016.drop_tail_recursive(3, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
    assert(S016.drop_builtins(3, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

}
