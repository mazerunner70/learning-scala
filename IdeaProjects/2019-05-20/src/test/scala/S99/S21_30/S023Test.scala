package S99.S21_30

import org.scalatest.FlatSpec

class S023Test extends FlatSpec {

  "S023: Extract a given number of randomly selected elements from a list." should "work" in {
    val list = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
    val selected = S023.randomSelect(3, list)
    assert(selected.length == 3)
  }

}
