package parsercombinator

import org.scalatest.FlatSpec

class EitherTest extends FlatSpec {

  "Either test" should "pass1" in {
    val either = new Either()
    val (value, successIndex) = either.eitherPass("aaaaab")
    assert(value == ())
    assert(successIndex == 6)
  }

  "Either test" should "fail1" in {
    val either = new Either()
    val (f, label, index, extra) = either.eitherFail("aaaaae")
    val trace = f.trace().longAggregateMsg
//    println(f.toString())
    assert (f.toString() == "Parsed.Failure(Position 1:6, found \"e\")")
//    println(trace)
    assert (trace == "Expected either:1:1 / (\"a\" | \"b\" | \"c\" | \"d\"):1:6, found \"e\"")
  }

}
