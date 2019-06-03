package parsercombinator

import org.scalatest.FlatSpec

class PcLogTest extends FlatSpec {

  "Log text" should "work" in {
    val pcLog = new PcLog()
    val logText = pcLog.demo("AB")
//    println(logText)
    val expected = "+Foo:1:1, cut\n  +DeepFailure:1:1\n  -DeepFailure:1:1:Failure(DeepFailure:1:1 / \"C\":1:1 ...\"AB\")\n-Foo:1:1:Success(1:3, cut)"
    assert(logText == expected)
  }

}
