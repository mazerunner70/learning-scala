package S99.S11_20

object S013 {

  def encodeDirect[A](list: List[A]): List[(Int, A)] = {
    if (list isEmpty) {
      Nil
    } else {
      val (spanList, remaining) = list span(element => element == list.head)
      (spanList length, spanList.head) :: encodeDirect(remaining)
    }
  }

}
