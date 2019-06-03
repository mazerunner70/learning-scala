package symbolicderivation

import fastparse.{Parsed, parse}
import org.scalatest.FlatSpec

class ParserTest extends FlatSpec {


  def parseConst(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, Parser.factor(_))
    (value, successIndex)
  }

  def parseBinaryOps(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, Parser.addSub(_))
    (value, successIndex)
  }

  def parseParens(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, Parser.addSub(_))
    (value, successIndex)
  }

  def parseLog(source: String) : (Any, Int) = {
    val Parsed.Success(value, successIndex) = parse(source, Parser.expr(_))
    (value, successIndex)
  }

  def derive(source:String) : Tree = {
    val Parsed.Success(value, successIndex) = parse(source, Parser.expr(_))
    val derived = SymDerivation.derive(value, "x")
    derived
  }



  "Parsing expression" should "generate a const object" in {
    val (value, successIndex) = parseConst("123")
    assert(value == Const(123))
    assert(successIndex == 3)
  }

  it should "generate a mult object" in {
    val (value, successIndex) = parseBinaryOps("123*2343")
    assert(value == Product(Const(123), Const(2343)))
    assert(successIndex == 8)
  }

  it should "generate a mult/div object" in {
    val (value, successIndex) = parseBinaryOps("123*2343/342")
    assert(value == Division(Product(Const(123.0),Const(2343.0)),Const(342.0)))
    assert(successIndex == 12)
  }

  it should "parse a add/sub object" in {
    val (value, successIndex) = parseBinaryOps("123*2343+342")
    assert(value == Sum(Product(Const(123.0),Const(2343.0)),Const(342.0)))
    assert(successIndex == 12)
  }

  it should "parse a paren object" in {
    val (value, successIndex) = parseBinaryOps( "123*(2343+342)")
    assert(value == Product(Const(123.0),Sum(Const(2343.0),Const(342.0))))
    assert(successIndex == 14)
  }

  it should "parse a ln object" in {
    val (value, successIndex) = parseBinaryOps( "ln(342)")
    assert(value == NatLog(Const(342.0)))
    assert(successIndex == 7)
  }

  "Sample question parsing" should "sample question 1" in {
    val (value, successIndex) = parseBinaryOps( "x*x/x")
    assert(value == Division(Product(Var("x"),Var("x")),Var("x")))
    assert(successIndex == 5)
  }

  it should "sample question 2" in {
    val (value, successIndex) = parseBinaryOps( "-45.78*x+x")
    assert(value == Sum(Product(Const(-45.78),Var("x")),Var("x")))
    assert(successIndex == 10)
  }

  it should "sample question 3" in {
    val (value, successIndex) = parseBinaryOps("-2.45*x*x+ln(x-3)")
    assert(value == Sum(Product(Product(Const(-2.45),Var("x")),Var("x")),NatLog(Minus(Var("x"),Const(3.0)))))
    assert(successIndex == 17)
  }

  it should "sample derivation 1" in {
    val value = derive( "x*x/x")
    assert(value == Division(Minus(Product(Sum(Product(Const(1.0),Var("x")),Product(Var("x"),Const(1.0))),Var("x")),
      Product(Product(Var("x"),Var("x")),Const(1.0))),Product(Var("x"),Var("x"))))
  }

  it should "sample derivation 2" in {
    val value = derive( "-45.78*x+x")
    assert(value == Sum(Sum(Product(Const(0.0),Var("x")),Product(Const(-45.78),Const(1.0))),Const(1.0)))
  }

  it should "sample derivation 3" in {
    val value = derive("-2.45*x*x+ln(x-3)")
    assert(value == Sum(Sum(Product(Sum(Product(Const(0.0),Var("x")),Product(Const(-2.45),Const(1.0))),Var("x")),Product(
      Product(Const(-2.45),Var("x")),Const(1.0))),Division(Minus(Const(1.0),Const(0.0)),Minus(Var("x"),Const(3.0)))))
  }



}
