package S99.S1_10

object S002 {

  def second_last_b[A](list: List[A]): A = {
    list.init.last
  }

  def second_last_case[A](list: List[A]): A = {
    list match {
      case element :: _ :: Nil => element
      case _ :: remaining => second_last_case(remaining)
      case _ => throw new NoSuchElementException
    }
  }

  def second_last_fn[A](list: List[A]): A = {
    if (list.length < 3)
      list.head
    else
      second_last_fn(list.tail)
  }
}
