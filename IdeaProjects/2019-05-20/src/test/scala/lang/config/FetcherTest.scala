package lang.config

import org.scalatest.{FlatSpec, FunSuite}
import lang.config.EnvConfig2._

class FetcherTest extends FlatSpec {

  "forLoop" should "work" in {
    val (extractorConfigE, config) = getApplicationConfig2[FetcherConfig]
    val result = Fetcher.forLoop(extractorConfigE)
    println(result)
  }

  "foorloop2" should "work" in {
    val result = Fetcher.forLoop2(List(1, 2, 30), List(5, 6))
    assert( result == List((1,5), (1,6), (2,5), (2,6), (30,5), (30,6)))
  }

  "for comprehension" should "show how either works" in {
    val r = Fetcher.forComprenhensionEither(Left("String 1"), Left("String 2"), Left("String 3"))
    assert(r == Left("String 1"))
  }

  "for comprehension" should "show how either works2" in {
    val r = Fetcher.forComprenhensionEither(Right(1), Right(2), Left("String 3"))
    assert(r == Left("String 3"))
  }

  "for comprehension" should "show how either works3" in {
    val r = Fetcher.forComprenhensionEither(Right(1), Right(2), Right(3))
    assert(r == Right(3))
  }

}

