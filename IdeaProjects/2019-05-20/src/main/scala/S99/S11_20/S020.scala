package S99.S11_20

object S020 {

    def removeAt[A](position: Int, list: List[A]): (List[A], A) = {
      list.splitAt(position) match {
        case (_, Nil) => throw new NoSuchElementException
        case (list1, element :: list2) => (list1 ::: list2, element)
      }
    }
}
