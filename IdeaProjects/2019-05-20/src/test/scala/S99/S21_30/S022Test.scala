package S99.S21_30

import org.scalatest.FlatSpec

class S022Test extends FlatSpec {

  "Test 022: Create a list containing all integers within a given range." should "work" in {
    assert(S022.range(4, 9) == List(4, 5, 6, 7, 8, 9))
    assert(S022.range2(4, 9) == List(4, 5, 6, 7, 8, 9))
    assert(S022.range3(4, 9) == List(4, 5, 6, 7, 8, 9))
  }

}
