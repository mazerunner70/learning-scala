package S99.S11_20

import org.scalatest.FlatSpec

class S020Test extends FlatSpec {

  "Test 020: Remove the Kth element from a list." should "work" in {
    val list = List('a, 'b, 'c, 'd)
    assert(S020.removeAt(1, list)== (List('a, 'c, 'd),'b))
    assert(S020.removeAt(0, list)== (List('b, 'c, 'd),'a))
  }

}
