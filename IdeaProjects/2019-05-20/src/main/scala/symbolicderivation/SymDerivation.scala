package symbolicderivation

import scala.math.log

object SymDerivation {
  type Environment = String => Double

  def eval(t: Tree, e: Environment) : Double = t match {
    case Const(c) => c
    case Var(v) => e(v)
    case Sum(l, r) => eval(l, e) + eval(r, e)
    case Minus(l, r) => eval(l, e) - eval(r, e)
    case Product(l, r) => eval(l, e) * eval(r, e)
    case Division(l, r) => eval(l, e) / eval(r, e)
    case NatLog(p) => log(eval(p, e))
  }

  def derive(t: Tree, term: String) : Tree = t match {
    case Var(v) if v == term => Const(1)
    case Sum(l, r) => Sum(derive(l, term), derive(r, term))
    case Minus(l, r) => Minus(derive(l, term), derive(r, term))
    case Product(l, r) => Sum( Product(derive(l, term), r), Product(l, derive(r, term)))
    case Division(l, r) => Division(Minus(Product(derive(l, term), r), Product(l, derive(r, term))), Product(r, r))
    case NatLog(p) => Division(derive(p, term), p)
    case _ => Const(0)
  }

    def main(args: Array[String]): Unit = {
    val t = Division(Product(Var("x"), Var("x")), Var("x"))
    println(t)
    println(eval(t, {case "x" => 5}))
    println(derive(t, "x"))
  }

}


