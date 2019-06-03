package S99.S1_10

object S003 {

  def nth_b[A](list: List[A], index: Int): A = {
    list(index)
  }

  def nth_case[A](list: List[A], index: Int): A = {
    (list, index) match {
      case (element :: remaining, 0)     => element
      case (_       :: remaining, count) => nth_case(remaining, count-1)
      case (Nil                 , _)     => throw new NoSuchElementException
    }
  }

  def nth_fn[A](list:List[A], index: Int): A = {
    if (index < 0 || list.isEmpty)
      throw new NoSuchElementException
    if (index == 0) list.head else nth_fn(list.tail, index-1)
  }

}
