package symbolicderivation

import fastparse.NoWhitespace._
import fastparse._

object Parser {

  def evalConst(parsed: String): Tree = Const(parsed.toDouble)
  def evalTerm(parsed: String): Tree = Var(parsed)

  def evalBinary(parsed: (Tree, Seq[(String, Tree)])): Tree = {
    val (base, ops) = parsed
    ops.foldLeft(base){
      case (left, (op, right)) => op match{
        case "+" => Sum(left, right)
        case "-" => Minus(left, right)
        case "*" => Product(left, right)
        case "/" => Division(left, right)
      }}
  }

  def evalUnaryFunction(parsed: (String, Tree)): Tree = {
    val (op, value) = parsed
    op match{
        case "ln" => NatLog(value)
      }
  }

  def number[_: P]: P[Tree] = P( (CharIn("+\\-").? ~ CharIn("0-9").rep(1) ~ ("." ~ CharIn("0-9").rep(1)).?).!.map(evalConst))
  def term  [_: P]: P[Tree] = P( CharIn("a-z").!.map(evalTerm) ~ !CharIn("a-z") )
  def parens[_: P]: P[Tree] = P( "(" ~/ addSub ~ ")" )
  def ln    [_: P]: P[Tree] = P( "ln".! ~ "(" ~/ addSub ~ ")" ).map(evalUnaryFunction)
  def factor[_: P]: P[Tree] = P( number | term | parens | ln)
  def divMul[_: P]: P[Tree] = P( factor ~ (CharIn("*/").! ~/ factor).rep ).map(evalBinary)
  def addSub[_: P]: P[Tree] = P( divMul ~ (CharIn("+\\-").! ~/ divMul).rep ).map(evalBinary)
  def expr  [_: P]: P[Tree] = P( addSub ~ End )

}
