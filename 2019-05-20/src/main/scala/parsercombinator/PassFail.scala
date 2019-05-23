package parsercombinator

import fastparse._, NoWhitespace._

class PassFail {

  def pass(source: String): (Any, Int) = {
    // No custom parser to create
    val Parsed.Success(value, successIndex) = parse(source, Pass(_))
    (value, successIndex)
  }

  def fail(source: String): (Parsed.Failure, String, Int, Any) = {
    // No custom parser to create
    val f @ Parsed.Failure(label, index, extra) = parse(source, Fail(_))
    (f, label, index, extra)
  }

}
