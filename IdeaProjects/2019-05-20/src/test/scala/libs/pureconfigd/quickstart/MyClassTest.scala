package libs.pureconfigd.quickstart

import java.nio.file.Paths

import org.scalatest._

class MyClassTest extends FlatSpec {

  "Quckstart" should "do basic read" in {
    val myDataClass = Right(Company(CompanyDetails("Knoldus Software LLP",2012,"80-120",List("India", "Singapore", "US", "Canada"),Map("development" -> "Noida", "head-office" -> "Delhi"),None)))
    def result = MyClass.run(Paths.get("./target/scala-2.12/test-classes/application-quickstart.conf"))
    assert(result == myDataClass)
  }

}
