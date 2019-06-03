package parsercombinator

import fastparse.NoWhitespace._
import fastparse._

class PCMap {

  def pass1(source: String): (Any, Int) = {
    def binary[_:P] = P( ("0" | "1" ).rep.!)
    def binaryNum[_:P] = P( binary.map(Integer.parseInt(_, 2)))
    val Parsed.Success(value, successIndex) = parse(source, binary(_))
    (value, successIndex)
  }

  def pass2(source: String): (Any, Int) = {
    def binary[_:P] = P( ("0" | "1" ).rep.!)
    def binaryNum[_:P] = P( binary.map(Integer.parseInt(_, 2)))
    val Parsed.Success(value, successIndex) = parse(source, binaryNum(_))
    (value, successIndex)
  }

}
