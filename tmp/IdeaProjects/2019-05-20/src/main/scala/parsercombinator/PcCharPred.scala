package parsercombinator

import fastparse._, NoWhitespace._

class PcCharPred {

  def cp[_:P] = P( CharPred(_.isUpper).rep.! ~ "."~ End)

  def pass(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, cp(_))
    (value, successIndex)
  }

  def fail(source: String) : (Parsed.Failure, String, Int, Any) = {
    val f @ Parsed.Failure(label, index, extra) = parse(source, cp(_))
    (f, label, index, extra)
  }

}
