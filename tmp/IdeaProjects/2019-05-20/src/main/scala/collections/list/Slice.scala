package collections.list

/** Taken from 2.23 List class
  * https://github.com/scala/scala/blob/v2.12.8/src/library/scala/collection/immutable/List.scala#L1
  *
  * Method is implemented:
  * override def slice(from: Int, until: Int): List[A] = {
  * val lo = scala.math.max(from, 0)
  * if (until <= lo || isEmpty) Nil
  * else this drop lo take (until - lo)
  * }
  *
  */
class Slice {

  def slice[A](list: List[A], from: Int, until: Int): List[A] = {
    list.slice(from, until)
  }

  /** Understand this line:
    * this drop lo take (until - lo)
    *
    */
  def drop1[A](list: List[A], count: Int) = {
    list.drop(count)
  }

  def drop2[A](list: List[A], count: Int) = {
    list drop count
  }

  def take1[A](list: List[A], count: Int) = {
    list take count
  }

  def take2[A](list: List[A], count: Int) = {
    list take count
  }

  def drop3[A](list: List[A], count: Int) = {
    list drop count take count
  }

  def drop4[A](list: List[A], count: Int) = {
    list.drop(count) take count
  }

  def drop5[A](list: List[A], count: Int) = {
    list drop count take(count)
  }



}
