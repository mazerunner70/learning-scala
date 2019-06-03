package parsercombinator.math

import org.scalatest.FlatSpec

class EvalTest extends FlatSpec {

  "basic eval" should "pass" in {
    val eval = new Eval()
    val (value, successIndex) = eval.pass("1+1")
    assert(value == 2)
    assert(successIndex == 3)
  }

  it should "pass2" in {
    val eval = new Eval()
    val (value, successIndex) = eval.pass("((1+1*2)+(3*4*5))/3")
    assert(value == 21)
    assert(successIndex == 19)
  }

}
