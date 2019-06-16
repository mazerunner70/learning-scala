package S99.S1_10

import org.scalatest.{FlatSpec, FunSuite}

class S009Test extends FlatSpec {

  "S009 - Pack consecutive duplicates of list elements into sublists." should "work" in {
    val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    assert(S009.packList_fn(list) == List(List('a', 'a', 'a', 'a'), List('b'), List('c', 'c'), List('a', 'a'), List('d'), List('e', 'e', 'e', 'e')))
  }

}
