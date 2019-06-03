package parsercombinator

import fastparse._
import NoWhitespace._
import fastparse.internal.Logger

class PcLog {

  def demo(source: String) : String = {
    val logged = collection.mutable.Buffer.empty[String]
    implicit val logger = Logger(logged.append(_))
    def DeepFailure[_:P] = P( "C" ).log
    def Foo[_:P] = P( (DeepFailure | "A") ~ "B".!).log

    parse(source, Foo(_))

    logged.mkString("\n")

  }

}
