package collections.list

import org.scalatest.FlatSpec

class SliceTest extends FlatSpec {

  "List.slice" should "work1" in {
    val slice = new Slice()
    val list = List(12, 34, 56, 78, 90, 122)
    val result = slice.slice(list,2, 3)
    assert(result == List(56))
  }

  "List.slice" should "work in edge cases1" in {
    val slice = new Slice()
    val list = List(12, 34, 56, 78, 90, 122)
    val result = slice.slice(list,-2, 3)
    assert(result == List(12, 34, 56))
  }

  "List.slice" should "work2" in {
    val slice = new Slice()
    val list = List(12, 34, 56, 78, 90, 122)
    val result = slice.slice(list,0, 6)
    assert(result == List(12, 34, 56, 78, 90, 122))
  }

  "List.slice" should "work in edge cases 2" in {
    val slice = new Slice()
    val list = List(12, 34, 56, 78, 90, 122)
    val result = slice.slice(list,-2, 72)
    assert(result == List(12, 34, 56, 78, 90, 122))
  }

}
