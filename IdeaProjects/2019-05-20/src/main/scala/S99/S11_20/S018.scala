package S99.S11_20

object S018 {

  def slice_builtin[A](start: Int, end: Int, list: List[A]): List[A] = {
    list.slice(start, end)
  }

  def slice_recursive[A](start: Int, end: Int, list: List[A]): List[A] = {
    (start, end, list) match {
      case (0, 0, _) => Nil
      case (0, end, h :: remaining) => h :: slice_recursive(0, end-1, remaining)
      case (start, end, _ :: remaining) => slice_recursive(start-1, end-1, remaining)

    }
  }

  def slice_tail_recursive[A](start: Int, end: Int, list: List[A]): List[A] = {
    def sliceR[A](s: Int, e: Int, curList: List[A], result: List[A]): List[A] = {
      (s, e, curList) match {
        case (0, 0, _) => result.reverse
        case (0, end, h :: remaining) => sliceR(0, e-1, remaining, h :: result)
        case (start, end, _ :: remaining) => sliceR(s-1, e-1, remaining, Nil)

      }
    }
    sliceR(start, end, list, Nil)
  }

}
