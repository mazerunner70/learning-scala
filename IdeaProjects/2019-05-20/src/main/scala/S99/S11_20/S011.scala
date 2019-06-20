package S99.S11_20

import S99.S1_10.S010

object S011 {

  def encodingModified[A](list: List[A]): List[Any] = {
    S010.encoding(list).map {
      tup => if (tup._1 == 1) tup._2 else tup
    }
  }

  def encodingModified_typesafe[A](list: List[A]): List[Either[(Int, A), A]] = {
    S010.encoding(list).map {
      tup => if (tup._1 == 1) Right(tup._2) else Left(tup)
    }
  }

}
