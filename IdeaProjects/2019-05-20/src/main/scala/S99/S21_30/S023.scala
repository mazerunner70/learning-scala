package S99.S21_30

import S99.S11_20.S020

object S023 {

  def randomSelect[A](count: Int, list: List[A]): List[A] = {
    val r = scala.util.Random
    if (count<1) Nil
    else {
      val (newList, element) = S020.removeAt(r.nextInt(list.length), list)
      element :: randomSelect(count-1, newList)
    }
  }

}
