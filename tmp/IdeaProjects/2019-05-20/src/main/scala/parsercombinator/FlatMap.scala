package parsercombinator

import fastparse._, NoWhitespace._

class FlatMap {

  def pass(source: String): (Any, Int) = {
    def leftTag[_:P] = P( "<" ~ (!">" ~ AnyChar).rep(1).! ~ ">")
    def rightTag[_:P] (s: String) = P( "</" ~ s.! ~ ">")
    def xml[_:P] = P(leftTag.flatMap(rightTag))
    val Parsed.Success(value, successIndex) = parse(source, xml(_))
    (value, successIndex)
  }

}
