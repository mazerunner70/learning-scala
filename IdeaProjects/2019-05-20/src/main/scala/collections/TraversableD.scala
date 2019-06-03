package collections

object TraversableD {

  def add[A, B](traversableFrom: Traversable[A], traversableTo: Traversable[B]):Traversable[Any] = {
    traversableFrom ++ traversableTo
  }

}
