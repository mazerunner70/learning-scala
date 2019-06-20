package S99.S11_20

import org.scalatest.FlatSpec

class S011Test extends FlatSpec {

  "S011 - Modified run-length encoding." should "work" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    assert (S011.encodingModified(list) == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
    assert (S011.encodingModified_typesafe(list) == List(Left((4,'a)), Right('b), Left((2,'c)), Left((2,'a)), Right('d), Left((4,'e))))
  }

}
