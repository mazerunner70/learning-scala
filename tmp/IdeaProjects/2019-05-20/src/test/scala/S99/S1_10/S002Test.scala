package S99.S1_10

import org.scalatest.FlatSpec

class S002Test extends FlatSpec {

  "S002 - Find the last but one element of a list" should "pass with Ints" in {
    val list = List(2, 6, 3, 7, 4, 2, 2)
    assert(S002.second_last_b(list) == 2)
    assert(S002.second_last_case(list) == 2)
    assert(S002.second_last_fn(list) == 2)
  }

  it should "pass with a String" in {
    val list = "abcdefgh"
    assert(S002.second_last_b(list.toList) == 'g')
    assert(S002.second_last_case(list.toList) == 'g')
    assert(S002.second_last_fn(list.toList) == 'g')
  }



}
