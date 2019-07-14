package S99.S21_30

import org.scalatest.FlatSpec

class S024Test extends FlatSpec {

  "S024: Lotto: Draw N different random numbers from the set 1..M." should "work" in {
    val list = S024.lotto(6, 49)
    assert(list.length == 6)
  }

}
