package examplea

abstract class Tree {}

case class Sum(l: derive.Tree, r: derive.Tree) extends derive.Tree

case class Minus(l: derive.Tree, r: derive.Tree) extends derive.Tree

case class Var(n: String) extends derive.Tree

case class Const(v: Int) extends derive.Tree

object Calculator {
  type Environment = String => Int

  def eval (t: derive.Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Minus(l, r) => eval(l, env) - eval(r, env)
    case Var(n)    => env(n)
    case Const(v)  => v
  }

  def main(args: Array[String]): Unit = {
    val vvar = Var("x")
    val vconst = Const(5)
    val venv : Environment = { case  "x" => 5}
    val vsum = Sum(vvar, vconst)
    val sumresult = eval( vsum, venv)
    println(sumresult)

    val vminus = Minus(vvar, vconst)
    val minusresult = eval(vminus, venv)
    println(minusresult)
  }

}

