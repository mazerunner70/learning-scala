package libs.pureconfig.quickstart

import org.scalatest._

class MyClassTest extends FlatSpec {

  "Quckstart" should "do basic read" in {
    val myDataClass = new MyDataClass(boolean = true, port = Port(8080), adt=AdtB(1), list=List(1, 0.2), map=Map("key"-> "value"), option = None)
    def result = MyClass.run()
    assert(result == Right(myDataClass))
  }

}
