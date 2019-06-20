package S99.S11_20

object S012 {

  def unpack_fn[A](list: List[(Int, A)]): List[A] = {
    list.foldRight(List[A]()) {(element, rest) =>
      val (count, symbol) = element
      List.fill(count)(symbol) ::: rest
    }
  }

  def unpack_flatmap[A](list: List[(Int, A)]): List[A] = {
    list flatMap( tup => List.fill(tup._1)(tup._2))
  }



}
