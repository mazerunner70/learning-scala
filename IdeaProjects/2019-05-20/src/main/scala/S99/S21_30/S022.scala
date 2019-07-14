package S99.S21_30

object S022 {

  def range(start: Int, end: Int): List[Int] = {
    List.tabulate(end-start+1){_+start}
  }

  def range2(start: Int, end: Int): List[Int] = {
    List.range(start, end+1)
  }

  def range3(start: Int, end: Int): List[Int] = {
    (start-1) match {
      case `end` => Nil
      case _ => start :: range3(start+1, end)
    }
  }

}
