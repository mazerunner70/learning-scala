package libs.pureconfigd.quickstart

import java.nio.file.{Files, Path, Paths}
import pureconfig.error.ConfigReaderFailures
import pureconfig.loadConfig
import pureconfig.generic.auto._

case class Company(company: CompanyDetails)
case class CompanyDetails(fullName: String,
                          started: Int,
                          employees: String,
                          offices: List[String],
                          officesInIndia: Map[String, String],
                          extraActivity: Option[String])

object MyClass {
  def run(path: Path):  Either[ConfigReaderFailures, Company] = {
    val simpleConfig: Either[ConfigReaderFailures, Company] = loadConfig[Company](path)
    simpleConfig match {
      case Left(ex) => ex.toList.foreach(println)
      case Right(config) => print(" ")
//        println(s"Company's Name ${config.company.fullName}")
//        println(s"Company started at ${config.company.started}")
//        println(s"Company's strength is ${config.company.employees}")
//        println(s"Company's presence are in  ${config.company.offices}")
//        println(s"Company's office in India are  ${config.company.officesInIndia}")
//        println(s"Company's extra activity is  ${config.company.extraActivity}")
    }
    simpleConfig
  }
}

