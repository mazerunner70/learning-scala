package parsercombinator

import fastparse._, NoWhitespace._

class CharsWhile {

  def cw[_: P] = P( CharsWhile(_ != ' ').!)

  def pass1(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, cw(_))
    (value, successIndex)
  }
}
