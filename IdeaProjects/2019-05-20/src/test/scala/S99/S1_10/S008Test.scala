package S99.S1_10

import org.scalatest.FlatSpec

class S008Test extends FlatSpec {

  "S008 - Eliminate consecutive duplicates of list elements." should "pass" in {
    val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    assert(S008.compressDuplicates_recursive(list) == List('a', 'b', 'c', 'a', 'd', 'e'))
    assert(S008.compressDuplicates_tail_recursive(list) == List('a', 'b', 'c', 'a', 'd', 'e'))
    assert(S008.compressDuplicates_functional(list) == List('a', 'b', 'c', 'a', 'd', 'e'))
  }

}
