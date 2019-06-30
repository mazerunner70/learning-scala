package S99.S11_20

import org.scalatest.FlatSpec

class S015Test extends FlatSpec {

  "S015: Duplicate the elements of a list a given number of times." should "work" in {
    val list = List('a, 'b, 'c, 'c, 'd)
    assert(S015.duplicateN(3, list) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
    assert(S015.duplicateN_flatmap(3, list) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

}
