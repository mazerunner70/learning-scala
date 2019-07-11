package S99.S11_20

object S019 {

  def rotate[A](count: Int, list: List[A]): List[A] = {
    val (listA, listB) = list.splitAt(count)
    listB ::: listA
  }

}
