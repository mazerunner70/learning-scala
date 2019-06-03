package parsercombinator

import fastparse._, NoWhitespace._

class AnyChar {

  def pass(source: String): (Any, Int) = {
    def pattern[_:P] = P("'" ~ AnyChar.! ~ "'")
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def fail(source: String): (Parsed.Failure, String, Int, Any) = {
    def pattern[_:P] = P("'" ~ AnyChar.! ~ "'")
    val f @ Parsed.Failure(label, index, extra)  = parse(source, pattern(_))
    (f, label, index, extra)
  }

}
