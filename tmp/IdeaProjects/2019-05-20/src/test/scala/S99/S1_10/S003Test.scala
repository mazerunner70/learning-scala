package S99.S1_10

import org.scalatest.FlatSpec

class S003Test extends FlatSpec {

  "S003 - Find the Kth element of a list" should "pass with int list" in {
    val list = List(1, 2, 3, 4,5 ,6 ,7 ,8)
    assert(S003.nth_b(list, 3) == 4)
    assert(S003.nth_case(list, 3) == 4)
    assert(S003.nth_fn(list, 3) == 4)
  }

  it should "pass with string list" in {
    val string = "abcdefghij"
    assert(S003.nth_b(string.toList, 3) == 'd')
    assert(S003.nth_case(string.toList, 3) == 'd')
    assert(S003.nth_fn(string.toList, 3) == 'd')
  }

}
