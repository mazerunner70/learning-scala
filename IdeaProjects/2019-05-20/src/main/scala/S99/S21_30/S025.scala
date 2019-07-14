package S99.S21_30

object S025 {

  def randomPermute[A](list: List[A]): List[A] = {
    S023.randomSelect(list.length, list)
  }

}
