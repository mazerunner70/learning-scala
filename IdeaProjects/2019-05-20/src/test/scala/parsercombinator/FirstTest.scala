package parsercombinator

import org.scalatest.FlatSpec

class FirstTest extends FlatSpec {


  "First Test" should "return simple success" in {
    val first = new First()
    val (value, successIndex) = first.matchSuccess1("a")
    assert(value == ())
    assert(successIndex == 1)
  }

  it should "return simple fail" in {
    val first = new First()
    val (f, label, index, extra) = first.matchFail1("b")
    assert(label == "")
    assert(index == 0)
    assert(f.msg == "Position 1:1, found \"b\"")
  }


  it must "understand tuple type" in {
    val first = new First()
    val (tup, i) = first.tupleReturnType()
    assert(tup == (1, 2, 3))
    assert(i == 4)
  }

}
