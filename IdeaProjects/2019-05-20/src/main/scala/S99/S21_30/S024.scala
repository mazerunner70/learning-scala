package S99.S21_30

object S024 {

  def lotto(count: Int, limit: Int): List[Int] = {
    val list: List[Int] = List.tabulate(limit) (x => x)
    S023.randomSelect(count, list)
  }

}
