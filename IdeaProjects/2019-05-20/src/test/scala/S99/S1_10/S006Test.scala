package S99.S1_10

import org.scalatest.FlatSpec

class S006Test extends FlatSpec {

  "S006 - Find out whether a list is a palindrome." should "confirm" in {
    val list = List(1, 2, 3, 4, 5, 6, 7,7 )
    val list2 = List(1, 2, 3, 4, 4, 3, 2, 1)
    assert(S006.isPalindrome_b(list) == false)
    assert(S006.isPalindrome_b(list2) == true)
  }


}
