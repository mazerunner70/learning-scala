package lang.config

import java.io.StringReader

import com.typesafe.config.{Config, ConfigFactory}
import pureconfig.error.ConfigReaderFailures
import pureconfig.{ConfigReader, Derivation, loadConfig}


/** Describes features seen here:
  * (url)
  */
object EnvConfig {


  def getConfig: Config = {
    sys.env.get("FETCHER_CONFIG").fold[Config](
      ConfigFactory.load()) {
      content => ConfigFactory.parseReader(new StringReader(content)).resolve()
    }
  }
  def getApplicationConfig[T](implicit reader: Derivation[ConfigReader[T]]): (Either[ConfigReaderFailures, T], Config) = {
    val rootConf = getConfig
    val conf = rootConf.getConfig("fetcher")
    (loadConfig[T](conf), rootConf)
  }

}
case class DBSourceExt(idTemplate: String, baseUri: String, table: String, db: DBSource)
case class DBSource(modelFile: String)

object DBSource extends Enumeration {

  type DBSource = Value
  val OBJECT, XML = Value

}


case class FetcherConfig(kafkaBroker: KafkaBrokerConfig,
                         kafkaProducer: KafkaProducerConfig,
                         tripleStoreConfig: TripleStoreConfig,
                         sourceName: String,
                         sources:List[DBSource],
                         batchSize: Int
                        )
case class KafkaBrokerConfig(bootstrapServers: String)
case class KafkaProducerConfig(topicOut: String, maxRequestSize: String = "5000000")
case class TripleStoreConfig(useHttps: Boolean,
                             tripleStoreHost: String,
                             tripleStorePort: Int,
                             mappingDb: String,
                             username: String,
                             password: String)
