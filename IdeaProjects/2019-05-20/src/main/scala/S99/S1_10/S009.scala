package S99.S1_10

object S009 {

  def packList_fn[A](list: List[A]): List[List[A]] = {
    list.foldRight(List[List[A]]()) { (h, r) =>
      if (r.isEmpty || r.head.head != h) {
        List(h) :: r
      } else {
        (h :: r.head) :: r.tail
      }
    }

  }

}
