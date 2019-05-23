package parsercombinator

import fastparse._, NoWhitespace._

class Capture {

  def capture1(source: String): (Any, Int) = {
    def pattern[_:P] = P("a".rep.! ~ "b" ~ End)
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def capture2(source: String): (Any, Int) = {
    def pattern[_:P] = P("a".rep.! ~ "b".! ~ End)
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def capture3(source: String): (Any, Int) = {
    def pattern[_:P] = P("a".rep.! ~ "b".! ~"c".! ~ End)
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def capture4(source: String): (Any, Int) = {
    def pattern[_:P] = P("a".!.rep ~ "b".! ~ End)
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def capture5(source: String): (Any, Int) = {
    def pattern[_:P] = P("a".rep ~ "b".!.? ~ End)
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

}
