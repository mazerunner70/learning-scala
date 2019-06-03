package parsercombinator

import fastparse._, NoWhitespace._

class Opaque {

  def demo(source: String): (String, String) = {
    def digit[_:P] = CharIn("0-9")
    def letter[_:P] = CharIn("0-9")
    def twice[T, _:P](p: => P[T]) = p ~ p
    def thrice[T, _:P](p: => P[T]) = p ~ p ~ p
    def errorMessage[T](p: P[_] => P[T], str: String) =
      parse(str, p).asInstanceOf[Parsed.Failure].trace().longAggregateMsg

    def numberPlate[_:P] = P( twice(letter) ~ twice(digit) ~ " " ~ thrice(letter))

    val err1 = errorMessage(numberPlate(_), source)

    def opaqueNumberPlate[_:P] = numberPlate.opaque("<number plate>")

    val err2 = errorMessage(opaqueNumberPlate(_), source)

    (err1, err2)
  }

}
