package S99.S1_10

object S007 {

  def flatten_default(list: List[Seq[String]]) :List[String] = {
    list.flatten
  }

  def flatten_b[A](list: List[A]): List[A] = {
    list.flatten { a =>
      a match {
        case ms: List[A]=> ms
        case a => List(a)
      }
    }
  }

  def flatten_nested_b[A](list: List[A]): List[A] = {
    list.flatten { a =>
      a match {
        case ms: List[A]=> flatten_nested_b(ms)
        case a => List(a)
      }
    }
  }

  def flatMap_flatten_b[A](list: List[A]): List[A] = {
    list.flatMap({
      case ms: List[A]=> ms
      case a => List(a)
    })
  }

  def flatMap_flatten_nested_b[A](list: List[A]): List[A] = {
    list.flatMap {
        case ms: List[A]=> flatten_nested_b(ms)
        case a => List(a)
    }
  }
  
}
