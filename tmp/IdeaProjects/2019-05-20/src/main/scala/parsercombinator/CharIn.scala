package parsercombinator

import fastparse._, NoWhitespace._

class CharIn {

  def ci[_:P] = P( CharIn("abc", "xyz").rep.! ~ End)

  def ciPass(source: String): (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, ci(_))
    (value, successIndex)
  }

  def ciFail(source: String): (Parsed.Failure, String, Int, Any) = {
    val f @ Parsed.Failure(label, index, extra) = parse(source, ci(_))
    (f, label, index, extra)
  }

  def digits[_:P] = P( CharIn("0-9").rep.!)

  def digitsPass(source: String): (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, digits(_))
    (value, successIndex)
  }

  def digitsFail(source: String): (Parsed.Failure, String, Int, Any) = {
    val f @ Parsed.Failure(label, index, extra) = parse(source, digits(_))
    (f, label, index, extra)
  }


}
