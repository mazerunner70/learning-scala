package S99.S11_20

import scala.annotation.tailrec

object S017 {

  def split[A](count: Int, list: List[A]): (List[A], List[A]) = {
    @tailrec def splitR[A](c: Int, curList: List[A], result: List[A]): (List[A], List[A])  = {
      (c, curList) match {
        case (_, Nil) => (result.reverse, Nil)
        case (0, h :: tail) => (result.reverse, curList)
        case (_, h :: tail) => splitR(c-1, tail, h :: result)
      }
    }
    splitR(count, list, Nil)
  }

  // Builtin.
  def splitBuiltin[A](n: Int, ls: List[A]): (List[A], List[A]) = ls.splitAt(n)

  // Simple recursion.
  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = (n, ls) match {
    case (_, Nil)       => (Nil, Nil)
    case (0, list)      => (Nil, list)
    case (n, h :: tail) => {
      val (pre, post) = splitRecursive(n - 1, tail)
      (h :: pre, post)
    }
  }

  // Functional (barely not "builtin").
  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
    (ls.take(n), ls.drop(n))


}
