package S99.S1_10

object S001 {

  //Builtin
  def last_b[A](list: List[A]): A = {
    list.last
  }

  def last_case[A](list: List[A]): A = {
    list match {
      case element :: Nil => element
      case _ :: remaining => last_case(remaining)
      case _ => throw new NoSuchElementException
    }
  }

  def last_fn[A](list: List[A]): A = {
    if (list.length > 1)
      last_fn(list.tail)
    else
      list.head
  }

}
