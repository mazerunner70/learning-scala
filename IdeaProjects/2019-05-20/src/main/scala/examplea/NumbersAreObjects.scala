package examplea

object NumbersAreObjects {
  def main(args: Array[String]): Unit = {
    println(1 + 2 * 3 / 4)
    println((1).+(((2).*(3))./(4)))
  }
}
