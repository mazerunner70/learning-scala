package S99.S1_10

import org.scalatest.FlatSpec

class S001Test extends FlatSpec {


  "S001 - Find the last element of a list" should "pass with Ints" in {
    val list = List(2, 6, 3, 7, 4, 2, 2)
    assert(S001.last_b(list) == 2)
    assert(S001.last_case(list) == 2)
    assert(S001.last_fn(list) == 2)
  }

  it should "pass with a String" in {
    val list = "abcdefgh"
    assert(S001.last_b(list.toList) == 'h')
    assert(S001.last_case(list.toList) == 'h')
    assert(S001.last_fn(list.toList) == 'h')
  }

}
