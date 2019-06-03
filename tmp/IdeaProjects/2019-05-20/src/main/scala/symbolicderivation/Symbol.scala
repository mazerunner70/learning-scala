package symbolicderivation

abstract class Tree

case class Const(c: Double) extends Tree

case class Var(v: String) extends Tree

case class Sum(l: Tree, r: Tree) extends Tree

case class Minus(l: Tree, r: Tree) extends Tree

case class Product(l: Tree, r: Tree) extends Tree

case class Division(l: Tree, r: Tree) extends Tree

case class NatLog(t: Tree) extends Tree




class Symbol {

}
