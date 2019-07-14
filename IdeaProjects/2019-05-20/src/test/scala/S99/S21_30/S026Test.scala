package S99.S21_30

import org.scalatest.FlatSpec

class S026Test extends FlatSpec {

  "S026: Generate the combinations of 1 distinct object chosen from the N elements of a list." should "work" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f)
    assert(S026.combinations(1, list) == List(List('a), List('b), List('c), List('d), List('e), List('f)))
    assert(S026.combinations(2, list) == List(List('a, 'b), List('a, 'c), List('a, 'd), List('a, 'e), List('a, 'f), List('b, 'c), List('b, 'd), List('b, 'e), List('b, 'f), List('c, 'd), List('c, 'e), List('c, 'f), List('d, 'e), List('d, 'f), List('e, 'f)))
    assert(S026.combinations(3, list) == List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), List('a, 'b, 'f), List('a, 'c, 'd), List('a, 'c, 'e), List('a, 'c, 'f), List('a, 'd, 'e), List('a, 'd, 'f), List('a, 'e, 'f), List('b, 'c, 'd), List('b, 'c, 'e), List('b, 'c, 'f), List('b, 'd, 'e), List('b, 'd, 'f), List('b, 'e, 'f), List('c, 'd, 'e), List('c, 'd, 'f), List('c, 'e, 'f), List('d, 'e, 'f)))
  }

}
