package examplea

class Complex(real: Double, imaginary: Double) {
  def re() = real
  def im() :Double = imaginary
}

object ComplexNumbers {
  def main(args: Array[String]): Unit = {
    val c = new Complex2(1.2, 3.4)
    println("imaginary part: " + c.im)
    println("complex: " + c)
  }
}

class Complex2(real: Double, imaginary: Double) {
  def re = real
  def im = imaginary
  override def toString()=
    "" + re + (if (im < 0) "-" else "+") + im + "i"
}