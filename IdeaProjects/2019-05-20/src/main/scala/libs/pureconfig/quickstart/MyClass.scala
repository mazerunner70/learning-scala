package libs.pureconfig.quickstart

import pureconfig._
import pureconfig.error.ConfigReaderFailures
import java.nio.file.{Files, Path, Paths}


sealed trait MyAdt
case class AdtA(a: String) extends MyAdt
case class AdtB(b: Int) extends MyAdt
final case class Port(value: Int) extends AnyVal
case class MyDataClass(
                    boolean: Boolean,
                    port: Port,
                    adt: MyAdt,
                    list: List[Double],
                    map: Map[String, String],
                    option: Option[String])

object MyClass {
  def run():  Either[ConfigReaderFailures, MyDataClass] = {
    pureconfig.loadConfig[MyDataClass](Paths.get("/media/sf_vm-data/repo/personal/learn-scala2/target/scala-2.12/test-classes/application-quickstart.conf"))
  }
}

