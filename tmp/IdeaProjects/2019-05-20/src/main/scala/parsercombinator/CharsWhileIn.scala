package parsercombinator

import fastparse._, NoWhitespace._

class CharsWhileIn {

  def cw[_:P] = P( CharsWhileIn("123456789").!)

  def pass(source: String): (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, cw(_))
    (value, successIndex)
  }
}
