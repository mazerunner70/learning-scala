package parsercombinator

import fastparse._, NoWhitespace._

class PositiveLookahead {

  def pass1(source: String): (Any, Int) = {
    def pattern[_:P] = P( ("hello" ~ &(" ")).!.rep )
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

}
