package parsercombinator.cuts

import fastparse._, NoWhitespace._

class NoCuts {

  def alpha[_: P] = P( CharIn("a-z"))
  def nocut[_: P] = P("val "~ alpha.rep(1).! | "def " ~ alpha.rep(1).!)

  def pass(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, nocut(_))
    (value, successIndex)
  }

  def fail(source: String): (Parsed.Failure, String, Int, Any, String) = {
    val f @ Parsed.Failure(label, index, extra) = parse(source, nocut(_))
    val trace = f.trace().longAggregateMsg
    (f, label, index, extra, trace)
  }


}
