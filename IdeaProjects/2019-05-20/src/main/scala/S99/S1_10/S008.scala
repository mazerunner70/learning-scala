package S99.S1_10

import scala.annotation.tailrec

object S008 {

  def compressDuplicates_recursive[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case h :: tail => h :: compressDuplicates_recursive(tail.dropWhile(_ == h))
    }
  }

  def compressDuplicates_tail_recursive[A](list: List[A]): List[A] = {
    @tailrec
    def compressR(result: List[A], curList: List[A]): List[A] = {
      curList match {
        case h :: tail => compressR(h::result, tail.dropWhile(_ == h))
        case Nil => result.reverse
      }
    }
    compressR(Nil, list)
  }

  def compressDuplicates_functional[A](list: List[A]) : List[A] = {
    list.foldRight(List[A]()) {(h, r) =>
      if (!r.isEmpty && h == r.head) r else h :: r
    }
  }

}
