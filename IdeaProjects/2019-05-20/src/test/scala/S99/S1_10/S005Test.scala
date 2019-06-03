package S99.S1_10

import org.scalatest.FlatSpec

class S005Test extends FlatSpec {

  "S005 - Reverse a list" should "reverse a list of int" in {
    val list = List(1, 2, 3, 4, 5, 6, 7,7 )
    assert(S005.reverse_b(list) == List(7, 7, 6, 5, 4, 3, 2, 1))
    assert(S005.reverse_recursion(list) == List(7, 7, 6, 5, 4, 3, 2, 1))
    assert(S005.reverse_tail_recursion(list) == List(7, 7, 6, 5, 4, 3, 2, 1))
    assert(S005.reverse_fn(list) == List(7, 7, 6, 5, 4, 3, 2, 1))

  }

}
