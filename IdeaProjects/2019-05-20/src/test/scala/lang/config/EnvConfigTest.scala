package lang.config

import com.typesafe.config._
import lang.config.EnvConfig._
import org.scalatest._
import pureconfig.loadConfig
import lang.config.EnvConfig2._
import pureconfig.generic.auto._

class EnvConfigTest extends FlatSpec {

  "EnvConfig" should "pass a basic test" in {
    val (extractorConfigE, config) = getApplicationConfig[FetcherConfig]
    assert(config.entrySet().size() == 54)
    assert(config.getString("fetcher.connection.profile") == "slick.jdbc.H2Profile$")
  }

  it should "understand getConfig2" in {
    assert(sys.env.get("FETCHER_CONFIG") == None)
    val config = getConfig
    assert(config.entrySet().size() == 54)
    assert(config.getString("fetcher.connection.profile") == "slick.jdbc.H2Profile$")
  }

  it should "understand how Option fold works" in {
    def doFold(ostring: Option[String]): String = {
      ostring.fold("was none") (_ => "was some")
    }
    val ostring = Some("str")
    assert(doFold(Some("something")) == "was some")
    assert(doFold(None) == "was none")
  }

  it should "understand list fold1" in {
    val prices = List(1.5, 2.0, 2.5)
    val sum = prices.fold(0.0)(_ + _)
    assert(sum == 6.0)
  }

  it should "understand list fold2" in {
    val prices = List(1.5, 2.0, 2.5)
    val sum = prices.fold(0.0) ((a, b) => a + b )
    assert(sum == 6.0)
  }

  it should "understand list fold3" in {
    val prices = List(1.5, 2.0, 2.5)
    val sumFunc: (Double, Double) => Double = (a, b) => a + b
    val sum = prices.fold(0.0) (sumFunc)
    assert(sum == 6.0)
  }

  it should "understand list fold4" in {
    val prices = List(1.5, 2.0, 2.5)
    val sumFunc: (Double, Double) => Double = (a, b) => a + b
    val sum = prices.fold(0.0) (sumFunc)
    assert(sum == 6.0)
  }

  "getApplicationConfig" should "work" in {
    val rootConf = ConfigFactory.load("application2.conf")
    val conf = rootConf.getConfig("fetcher")
    val parsed = loadConfig[FetcherConfig](conf)
    val result = getApplicationConfig[FetcherConfig]
  }

  it should "work in real class" in {
    val (extractorConfigE, config) = getApplicationConfig2[FetcherConfig]
    assert(config.entrySet().size() == 65)
    assert(config.getString("fetcher.connection.profile") == "slick.jdbc.OracleProfile$")
    assert(extractorConfigE == Right(
      FetcherConfig(
        KafkaBrokerConfig("dummy1"),
        KafkaProducerConfig("m-raw-pp","5000000"),
        TripleStoreConfig(true,"stardog.dev.k8s.me.com",443,"ExtractionMappings","dummyadmin","dummyadmin"),
        "pp",
        List(DBSource("https://data.me.com/ls/extraction/pp/bioassay"),
          DBSource("https://data.me.com/ls/extraction/pp/dosetype"),
          DBSource("https://data.me.com/ls/extraction/pp/adverseeffect"),
          DBSource("https://data.me.com/sl/extraction/pp/fdatype"),
          DBSource("https://data.me.com/ls/extraction/pp/emeatype"),
          DBSource("https://data.me.com/ls/extraction/pp/emeadocument"),
          DBSource("https://data.me.com/ls/extraction/pp/fdadocument"),
          DBSource("https://data.me.com/ls/extraction/pp/route"),
          DBSource("https://data.me.com/ls/extraction/pp/pkparameter"),
          DBSource("https://data.me.com/ls/extraction/pp/source"),
          DBSource("https://data.me.com/ls/extraction/pp/species"),
          DBSource("https://data.me.com/ls/extraction/pp/drug"),
          DBSource("https://data.me.com/ls/extraction/pp/pkassay"),
          DBSource("https://data.me.com/ls/extraction/pp/safetyassay"),
          DBSource("https://data.me.com/ls/extraction/pp/brandname"),
          DBSource("https://data.me.com/ls/extraction/pp/drugclass"),
          DBSource("https://data.me.com/sl/extraction/pp/pdffile")),
        10000
      )))
  }



}



//case class AppConf(connection: ConnectConf)
//case class ConnectConf(profile: String, db: DbConf)
//case class DbConf(url: String, driver: String, keepAliveConnection: String,
//                  connectionPool: String, user: String, password: String)
//object DBSource extends Enumeration {
//
//  type DBSource = Value
//  val OBJECT, XML = Value
//
//}
//
//case class DBSource(idColumn: String, modelFile: String)
//
//case class FetcherConfig(kafkaBroker: KafkaBrokerConfig,
//                         kafkaProducer: KafkaProducerConfig,
//                         tripleStoreConfig: TripleStoreConfig,
//                         sourceName: String,
//                         sources:List[DBSource],
//                         batchSize: Int
//                        )
//case class KafkaBrokerConfig(bootstrapServers: String)
//case class KafkaProducerConfig(topicOut: String)
//case class TripleStoreConfig(useHttps: Boolean,
//                             tripleStoreHost: String,
//                             tripleStorePort: Int,
//                             mappingDb: String,
//                             username: String,
//                             password: String)
