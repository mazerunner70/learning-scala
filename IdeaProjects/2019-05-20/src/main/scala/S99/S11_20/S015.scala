package S99.S11_20

object S015 {

  def duplicateN[A](count: Int, list: List[A]): List[A] = {
    if (list isEmpty)
      Nil
    else
      List.fill(count)(list.head) ::: duplicateN(count, list.tail)
  }

  def duplicateN_flatmap[A](count: Int, list: List[A]): List[A] = {
    list.flatMap { List.fill(count) (_) }}

}
