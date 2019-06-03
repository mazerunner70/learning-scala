package parsercombinator

import fastparse._, NoWhitespace._

class Either {

  def eitherPass(source: String): (Any, Int) = {
    def either[_:P] = P("a".rep ~ ("b" | "c" | "d") ~ End)
    val Parsed.Success(value, successIndex) = parse(source, either(_))
    (value, successIndex)
  }

  def eitherFail(source: String): (Parsed.Failure, String, Int, Any)= {
    def either[_:P] = P("a".rep ~ ("b" | "c" | "d") ~ End)
    val f @ Parsed.Failure(label, index, extra)  = parse(source, either(_))
    (f, label, index, extra)
  }

}
