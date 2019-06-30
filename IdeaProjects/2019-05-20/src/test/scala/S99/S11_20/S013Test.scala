package S99.S11_20

import org.scalatest.FlatSpec

class S013Test extends FlatSpec {

  "Tes 013: Run-length encoding of a list (direct solution)." should " work" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    assert (S013.encodeDirect(list) == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

}
