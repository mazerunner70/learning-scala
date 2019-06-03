package parsercombinator

import fastparse._, NoWhitespace._

class Sequence {

  def parseSequence(source: String): (Any, Int) = {
    def ab[_: P] = P( "a" ~ "b")
    val Parsed.Success(value, successIndex) = parse(source, ab(_))
    (value, successIndex)
  }

  def parseSequenceFail(source: String): (Parsed.Failure, String, Int, Any) = {
    def ab[_: P] = P( "a" ~ "b")
    val f @ Parsed.Failure(label, index, extra) = parse(source, ab(_))
    (f, label, index, extra)
  }

}
