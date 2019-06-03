package collections

import org.scalatest.FlatSpec

class TraversableDTest extends FlatSpec {

  "Traversable" should "add traversables" in {
    def traversable =  List(1, 2, 3)
    def traversable2 =  List(4, 5, 6)
    def newObj = traversable ++ traversable2
    assert(newObj.isInstanceOf[List[Int]])
    assert(newObj == List(1, 2, 3, 4, 5, 6))
  }

}
