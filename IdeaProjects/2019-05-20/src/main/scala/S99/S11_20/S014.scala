package S99.S11_20

object S014 {

    def duplicate[A](list: List[A]): List[A] = {
      if (list.isEmpty)
        Nil
      else
        list.head :: list.head :: duplicate(list.tail)
    }

}
