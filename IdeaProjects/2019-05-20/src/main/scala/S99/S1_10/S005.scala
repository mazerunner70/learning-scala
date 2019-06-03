package S99.S1_10

/** Reverse a list
  *
  */
object S005 {

  def reverse_b[A](list: List[A]): List[A] = {
    list.reverse
  }

  def reverse_recursion[A](list: List[A]): List[A] = {
    list match {
      case element :: Nil => List(element)
      case element :: remaining => reverse_recursion(remaining) :+ element
    }
  }

  def reverse_tail_recursion[A](list: List[A]): List[A] = {
    def rev[A](list: List[A], reversedList: List[A]): List[A] = {
      (list, reversedList) match {
        case (element :: remaining, reversed) => rev(remaining, element :: reversed )
        case (Nil, reversed) => reversed
      }
    }
    rev(list, Nil)
  }

  def reverse_fn[A](list: List[A]): List[A] = {
    list.foldLeft(List[A]()) { (a, b) => b :: a }
  }

}
