package parsercombinator.cuts

import fastparse._, NoWhitespace._

class Cuts {

  def alpha[_: P] = P( CharIn("a-z"))
  def cut[_: P] = P( "val " ~/ alpha.rep(1).! | "def " ~/ alpha.rep(1).!)

  def pass(source: String): (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, cut(_))
    (value, successIndex)
  }

  def fail(source: String): (Parsed.Failure, String, Int, Any, String) = {
    val f @ Parsed.Failure(label, index, extra) = parse(source, cut(_))
    val trace = f.trace().longAggregateMsg
    (f, label, index, extra, trace)
  }


}
