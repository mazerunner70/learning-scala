package lang.config

import java.io.StringReader

import com.typesafe.config.{Config, ConfigFactory}
import pureconfig.error.ConfigReaderFailures
import pureconfig.{ConfigReader, Derivation, loadConfig}


/** Describes features seen here:
  * (url)
  */
object EnvConfig2 {


  def getConfig2: Config = {
    sys.env.get("FETCHER_CONFIG").fold[Config](
      ConfigFactory.load("application2.conf")) {
      content => ConfigFactory.parseReader(new StringReader(content)).resolve()
    }
  }
  def getApplicationConfig2[T](implicit reader: Derivation[ConfigReader[T]]): (Either[ConfigReaderFailures, T], Config) = {
    val rootConf = getConfig2
    val conf = rootConf.getConfig("fetcher")
    (loadConfig[T](conf), rootConf)
  }

}
