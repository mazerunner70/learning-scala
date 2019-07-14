package S99.S21_30

import org.scalatest.FlatSpec

class S021Test extends FlatSpec {
    "S021: Insert an element at a given position into a list." should "work" in {
      val list = List('a, 'b, 'c, 'd)
      assert(S021.insertAt('new, 1, list) == List('a, 'new, 'b, 'c, 'd))
    }
}
