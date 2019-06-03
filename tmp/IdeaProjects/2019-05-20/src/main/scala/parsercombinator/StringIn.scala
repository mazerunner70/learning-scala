package parsercombinator

import fastparse._, NoWhitespace._

class StringIn {

  def si[_: P] = P( StringIn("cow", "cattle").!.rep(1))

  def pass(source: String): (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, si(_))
    (value, successIndex)
  }

  def fail(source: String): (Parsed.Failure, String, Int, Any) = {
    val f @ Parsed.Failure(label, index, extra) = parse(source, si(_))
    (f, label, index, extra)
  }



}
