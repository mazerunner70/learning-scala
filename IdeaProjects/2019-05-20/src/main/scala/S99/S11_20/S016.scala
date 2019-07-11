package S99.S11_20

import scala.annotation.tailrec

object S016 {

  def drop[A](count: Int, list:List[A]): List[A] = {
    if (list.length < count)
      list
    else {
      val (split, remaining) = list.splitAt(count-1)
      split ::: drop(count, remaining.tail)
    }
  }

  def drop_recursive[A](count: Int, list: List[A]): List[A] = {
    def dropR[A](c: Int, curList: List[A]): List[A] = {
      (c, curList) match {
        case (_, Nil)   => Nil
        case (1, _ :: t) => dropR(count, t)
        case (_, h :: t) => h :: dropR(c-1, t)
      }
    }
    dropR(count, list)
  }


  def drop_tail_recursive[A](count: Int, list: List[A]): List[A] = {
    @tailrec
    def dropR[A](c: Int, curList: List[A], result: List[A]): List[A] = {
      (c, curList) match {
        case (_, Nil) => result.reverse
        case (1, _ :: tail) => dropR(count, tail, result)
        case (_, h :: tail) => dropR(c-1, tail, h :: result)
      }
    }
    dropR(count, list, Nil)
  }

  def drop_builtins[A](count: Int, list: List[A]): List[A] = {
    list.zipWithIndex.filterNot{v=> (v._2+1) % count == 0} map { v=> v._1}
  }

}
