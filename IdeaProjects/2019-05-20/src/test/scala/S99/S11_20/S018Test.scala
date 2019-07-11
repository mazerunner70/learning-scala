package S99.S11_20

import org.scalatest.FlatSpec

class S018Test extends FlatSpec {

  "S018: Extract a slice from a list." should "work" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    assert(S018.slice_builtin(3, 7, list) == List('d, 'e, 'f, 'g))
    assert(S018.slice_recursive(3, 7, list) == List('d, 'e, 'f, 'g))
    assert(S018.slice_tail_recursive(3, 7, list) == List('d, 'e, 'f, 'g))
  }

}
