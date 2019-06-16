package S99.S1_10

import org.scalatest.FlatSpec

class S010Test extends FlatSpec {

  "S009 - Run-length encoding of a list." should " work" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    assert(S010.encoding(list) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

}
