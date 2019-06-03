package parsercombinator

import fastparse._, NoWhitespace._

class Index {

  def pass(source: String): (Any, Int) = {
    def finder[_:P] = P("hay".rep ~ Index ~ "needle" ~ "hay".rep )
    val Parsed.Success(value, successIndex) = parse("hayhayhayneedlehay", finder(_))
    (value, successIndex)
  }

}
