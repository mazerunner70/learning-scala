package symbolicderivation

import fastparse._
import org.scalatest.FlatSpec

class RendererTest extends FlatSpec {

  "Renderer" should "render positive numbers" in {
    val text = Renderer.render(Const(123))
    assert( text == "123")
  }

  it should "adjust signs correctly" in {
    assert(Renderer.adjustSigns("+", "123") == "+123")
    assert(Renderer.adjustSigns("+", "-123") == "-123")
  }

  it should "render example 1 correctly" in {
    val toRender = Division(Product(Var("x"),Var("x")),Var("x"))
    val rendered = Renderer.render(toRender)
    assert(rendered == "x^2/x")
  }

  it should "render example 2 correctly" in {
    val toRender = Sum(Product(Const(-45.78),Var("x")),Var("x"))
    val rendered = Renderer.render(toRender)
    assert(rendered == "-45.78*x+x")
  }
  it should "render example 3 correctly" in {
    val toRender = Sum(Product(Product(Const(-2.45),Var("x")),Var("x")),NatLog(Minus(Var("x"),Const(3.0))))
    val rendered = Renderer.render(toRender)
    assert(rendered == "-2.45*x*x+ln(x-3)")
  }

  it should "cope with power 2" in {
    val toParse = "x*x"
    val Parsed.Success(parsed, _) = parse(toParse, Parser.expr(_))
    assert(parsed == Product(Var("x"),Var("x")))
    val rendered = Renderer.render(parsed)
    assert(rendered == "x^2")
  }

  it should "power match" in {
    val lText = "x^2"
    val rTerm = "x"
    val rText = "x"
    val reg = """(\w)\^(\d+)""".r
    val result = lText match {
      case reg(term, power) if term == rTerm=> {
        term+"^"+(power.toInt+1).toString()
      }
      case reg(term, power) => "hello"
      case _ => lText+"*"+rText
    }
    assert(result == "x^3")
  }

  it should "cope with power 3" in {
    val toParse = "x*x*x"
    val Parsed.Success(parsed, _) = parse(toParse, Parser.expr(_))
    assert(parsed == Product(Product(Var("x"),Var("x")),Var("x")))
    val rendered = Renderer.render(parsed)
    assert(rendered == "x^3")
  }

  it should "render example 1 answer correctly" in {
    val toRender = Division(Minus(Product(Sum(Product(Const(1.0),Var("x")),Product(Var("x"),Const(1.0))),Var("x")),
      Product(Product(Var("x"),Var("x")),Const(1.0))),Product(Var("x"),Var("x")))
    val rendered = Renderer.render(toRender)
    assert(rendered == "((1*x+x*1)*x-x^2*1)/x^2")
  }
 it should "render example 2 answer correctly" in {
    val toRender = Sum(Sum(Product(Const(0.0),Var("x")),Product(Const(-45.78),Const(1.0))),Const(1.0))
    val rendered = Renderer.render(toRender)
    assert(rendered == "0*x-45.78*1+1")
  }
  it should "render example 3 answer correctly" in {
    val toRender = Sum(Sum(Product(Sum(Product(Const(0.0),Var("x")),Product(Const(-2.45),Const(1.0))),Var("x")),Product(
      Product(Const(-2.45),Var("x")),Const(1.0))),Division(Minus(Const(1.0),Const(0.0)),Minus(Var("x"),Const(3.0))))
    val rendered = Renderer.render(toRender)
    assert(rendered == "(0*x-2.45*1)*x-2.45*x*1+(1-0)/(x-3)")
  }
}
