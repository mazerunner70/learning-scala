package S99.S11_20

import org.scalatest.FlatSpec

class S017Test extends FlatSpec {

  "S017: Split a list into two parts." should "work" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    assert(S017.split(3, list) == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

}
