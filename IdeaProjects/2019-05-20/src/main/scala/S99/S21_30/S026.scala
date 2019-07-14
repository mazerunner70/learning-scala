package S99.S21_30

object S026 {

  def combinations[A](chosen: Int, list: List[A]): List[List[A]] = {
    def chooser[A](c: Int, remainList: List[A], stemList: List[A]): List[List[A]] = {
      c match {
        case 1 => (  remainList.map(x=>(x :: stemList).reverse))
        case _ => choiceR(c - 1, remainList, stemList)
      }
    }
    def choiceR[A](c: Int, remainList: List[A], stemList: List[A]): List[List[A]] = {
      remainList match {
        case Nil => Nil
        case _   => chooser(c, remainList.tail, remainList.head :: stemList) :::
      choiceR(c, remainList.tail, stemList)

      }
    }
    chooser(chosen, list, Nil)
  }

}
