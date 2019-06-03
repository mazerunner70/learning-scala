package S99.S1_10

import org.scalatest.FlatSpec

class S004Test extends FlatSpec {

  "004 - Find the number of elements of a list" should "pass with int list" in {
    val list = List(1, 2,3, 4, 5, 6, 7, 7, 8,9 )
    assert(S004.length_b(list) == 10)
    assert(S004.length_case(list) == 10)
    assert(S004.length_fn(list) == 10)
    assert(S004.length_fn2(list) == 10)
  }

  it should "pass with string" in {
    val string = "abcdefghij"
    assert(S004.length_b(string.toList) == 10)
    assert(S004.length_case(string.toList) == 10)
    assert(S004.length_fn(string.toList) == 10)
    assert(S004.length_fn2(string.toList) == 10)
  }

}
