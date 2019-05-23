package parsercombinator

import fastparse._, NoWhitespace._

class EndStart {

  def noEndPass(source: String): (Any, Int) = {
    def pattern[_: P] = P("a".rep ~ "b")
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def withEndFail(source: String): (Parsed.Failure, String, Int, Any) = {
    def pattern[_: P] = P("a".rep ~ "b" ~ End)
    val f @ Parsed.Failure(label, index, extra)  = parse(source, pattern(_))
    (f, label, index, extra)
  }

  def startPass( source: String): (Any, Int) = {
    def pattern[_: P] = P( (("a" | Start) ~ "b").rep ~ End).!
    val Parsed.Success(value, successIndex) = parse(source, pattern(_))
    (value, successIndex)
  }

  def startFail( source: String): (Parsed.Failure, String, Int, Any) = {
    def pattern[_: P] = P( (("a" | Start) ~ "b").rep ~ End).!
    val f @ Parsed.Failure(label, index, extra)  = parse(source, pattern(_))
    (f, label, index, extra)
  }

}
