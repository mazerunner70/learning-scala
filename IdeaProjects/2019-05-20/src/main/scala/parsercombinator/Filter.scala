package parsercombinator

import fastparse._, NoWhitespace._

class Filter {

  def pass(source: String): (Any, Int) = {
    def digits[_:P] = P(CharPred(c=> '0' <= c && c<='9').rep(1).!).map(_.toInt)
    def even[_:P] = P(digits.filter(_ % 2 == 0))
    val Parsed.Success(value, successIndex) = parse(source, even(_))
    (value, successIndex)
  }

  def fail(source: String): (Parsed.Failure, String, Int, Any) = {
    def digits[_:P] = P(CharPred(c=> '0' <= c && c<='9').rep(1).!).map(_.toInt)
    def even[_:P] = P(digits.filter(_ % 2 == 0))
    val f @ Parsed.Failure(label, index, extra) = parse(source, even(_))
    (f, label, index, extra)
  }

}
