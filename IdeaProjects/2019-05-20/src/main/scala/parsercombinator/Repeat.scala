package parsercombinator

import fastparse._, NoWhitespace._

class Repeat {

  def simpleRep(source: String): (Any, Int) = {
    def ab[_: P] = P("a".rep ~ "b")
    val Parsed.Success(value, successIndex) = parse(source, ab(_))
    (value, successIndex)
  }

  def separatorRep(source: String): (Any, Int) = {
    def abc[_: P] = P("a".rep(sep="b") ~ "c")
    val Parsed.Success(value, successIndex) = parse(source, abc(_))
    (value, successIndex)
  }

  def separatorRepFail(source: String): (Parsed.Failure, String, Int, Any)  = {
    def abc[_: P] = P("a".rep(sep="b") ~ "c")
    val f @ Parsed.Failure(label, index, extra) = parse(source, abc(_))
    (f, label, index, extra)
  }

  def separator4Rep(source: String): (Any, Int) = {
    def ab4[_: P] = P("a".rep(min=2, max=4, sep="b"))
    val Parsed.Success(value, successIndex) = parse(source, ab4(_))
    (value, successIndex)
  }

  def separator4RepFail(source: String): (Parsed.Failure, String, Int, Any)  = {
    def ab4[_: P] = P("a".rep(min=2, max=4, sep="b"))
    val f @ Parsed.Failure(label, index, extra) = parse(source, ab4(_))
    (f, label, index, extra)
  }

  def separator2ExactRep(source: String): (Any, Int) = {
    def ab2exactly[_: P] = P("ab".rep(exactly=2))
    val Parsed.Success(value, successIndex) = parse(source, ab2exactly(_))
    (value, successIndex)
  }

  def separatorAb4cRep(source: String): (Any, Int) = {
    def ab4c[_: P] = P("a".rep(min=2, max=4, sep="b") ~ "c")
    val Parsed.Success(value, successIndex) = parse(source, ab4c(_))
    (value, successIndex)
  }

  def separatorAb4cRepFail(source: String): (Parsed.Failure, String, Int, Any) = {
    def ab4c[_: P] = P("a".rep(min=2, max=4, sep="b") ~ "c")
    val f @ Parsed.Failure(label, index, extra) = parse(source, ab4c(_))
    (f, label, index, extra)
  }




}
