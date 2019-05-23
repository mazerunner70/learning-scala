package parsercombinator

import fastparse._, NoWhitespace._


/** Examples for parser failures:
  *
  * http://www.lihaoyi.com/fastparse/#Failures
  */
class Failures {

  def matchEitherFail(source: String): (Parsed.Failure, String, Int, Any) = {
    def parseEither[_: P] = P("a" | "b" )
    def parseA[_: P] = P( parseEither.? ~ "c")
    val f @ Parsed.Failure(label, index, extra) = parse(source, parseA(_))
    (f, label, index, extra)
  }


}
