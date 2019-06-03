package parsercombinator

import org.scalatest.FlatSpec

class OpaqueTest extends FlatSpec {

  "Opaque Test" should "demo" in {
    val opaqueTest = new Opaque()
    val (notOpaqueText, opaqueText) = opaqueTest.demo("LR52 OVB")
//    println(opaqueText)
    assert (notOpaqueText == "Expected numberPlate:1:1 / [0-9]:1:1, found \"LR52 OVB\"")
    assert (opaqueText == "Expected <number plate>:1:1, found \"LR52 OVB\"")
  }

}
