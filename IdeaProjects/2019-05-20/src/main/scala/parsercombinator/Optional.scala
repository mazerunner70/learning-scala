package parsercombinator

import fastparse._, NoWhitespace._

class Optional {

  def demoSuccess(source: String): (Any, Int) = {
    def option[_: P] = P( "c".? ~ "a".rep(sep="b").! ~ End)
    val Parsed.Success(value, successIndex) = parse(source, option(_))
    (value, successIndex)
  }

}
