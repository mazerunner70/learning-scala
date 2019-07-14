package S99.S21_30

object S021 {

    def insertAt[A](newElement: A, position: Int, list: List[A]): List[A] = {
      list.splitAt(position) match {
        case (Nil, _) => throw new NoSuchElementException
        case (list1, list2) => list1 ::: (newElement :: list2)
        case (_, Nil) => throw new NoSuchElementException
      }
    }

}
