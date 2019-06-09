package lang.config

import pureconfig.error.ConfigReaderFailures
import cats.implicits._
import com.typesafe.config.Config



object Fetcher {
  def forLoop[T](config: Either[ConfigReaderFailures, T]): Either[ConfigReaderFailures, T] = {
    val r = for {
      extractorConfig <- config
    } yield extractorConfig
    r
  }

  def forLoop2[A](list1: List[A], list2: List[A]): List[(A, A)] = {
    for {
      i <- list1
      j <- list2
    } yield (i, j)
  }

  /** This test uses the same idiom as
    * val r = for {
    * extractorConfig <- extractorConfigE
    * dBSourceExts    <- extractorConfig.sources.traverse(s => DBSourceExt(s, extractorConfig.tripleStoreConfig, normalized = true))
    * results         <- Either.catchNonFatal(new Fetcher(extractorConfig, config, dBSourceExts).process())
    * } yield results
    */
  def forComprenhensionEither[A](either1: Either[String, Int], either2: Either[String, Int], either3: Either[String, Int]): Either[String, Int] = {
    val r = for {
      e1 <- either1
      e2 <- either2
      e3 <- either3
    } yield e3
    r
  }

}