package S99.S1_10

object S004 {

  def length_b[A](list: List[A]): Int = {
    list.length
  }

  def length_case[A](list: List[A]): Int = {
    def length_case_sized[A](list: List[A], size: Int): Int = {
      (list, size) match {
        case (_ :: remaining, size) => length_case_sized(remaining, size + 1)
        case (Nil, size)            => size
      }
    }
    length_case_sized(list, 0)
  }

  def length_fn[A](list: List[A]): Int = {
    def length_fn_sized[A](list: List[A], size: Int): Int = {
      if (list.isEmpty)
        size
      else
        length_fn_sized(list.tail, size+1)
    }
    length_fn_sized(list, 0)
  }

  def length_fn2[A](list: List[A]): Int = {
    list.foldLeft(0) {(c, _) => c + 1 }
  }

}
