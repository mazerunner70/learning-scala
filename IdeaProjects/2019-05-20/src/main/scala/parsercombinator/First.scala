package parsercombinator

import fastparse._, NoWhitespace._

class First {
  def matchSuccess1(source: String): (Any, Int) = {
    def parseA[_: P] = P("a")
    val Parsed.Success(value, successIndex) = parse(source, parseA(_))
    (value, successIndex)
  }

  def matchFail1(source: String): (Parsed.Failure, String, Int, Any) = {
    def parseA[_: P] = P("hello")
    val f @ Parsed.Failure(label, index, extra) = parse(source, parseA(_))
    (f, label, index, extra)
  }


  // Supports a Stack overflow question: https://stackoverflow.com/questions/56253774/scala-how-to-specify-a-return-type-of-tuple-in-a-tuple
  def tupleReturnType(): (Product, Int) = {
    val tup = (1, 2, 3)
    val i = 4
    (tup, i)
  }
  // Suppports a Stack overflow question: https://stackoverflow.com/questions/56256850/scala-implicit-syntax-in-polymorphic-methods
  def implicitType(): (Any, Int) = {
//    def program[_: P] = parse("a", P("a"))
//    val Parsed.Success(value, successIndex) = program
    ((), 1)
  }

}

