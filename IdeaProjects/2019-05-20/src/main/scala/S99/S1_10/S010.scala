package S99.S1_10

object S010 {

  def encoding[A](list: List[A]): List[(Int, A)] = {
    S009.packList_fn(list).map {
      li => (li.length, li.head)
    }

  }

}
