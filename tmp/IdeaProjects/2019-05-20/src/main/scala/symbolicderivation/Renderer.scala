package symbolicderivation

object Renderer {

  def render (t: Tree): String = t match {
    case Const(c) => tidyDecimal(c.toString())
    case Var(c) => c
    case Sum(l, r) => render(l) + adjustSigns("+" , render(r))
    case Minus(l, r) => render(l) + adjustSigns("-", render(r))
//    case Product(l, r) => withParens(l) + "*" + withParens(r)
    case Product(l, r) => withPowers(l, r)
    case Division(l, r) => withParens(l) + "/" + withParens(r)
    case NatLog(t) => "ln("+render(t)+")"
  }

  def tidyDecimal(str: String): String =
    if (str.endsWith(".0")) str.dropRight(2) else str


  def adjustSigns(op: String, value: String): String = (op+value.head) match {
      case "+-" | "-+" => "-"+value.substring(1)
      case "++" | "--" => "+"+value.substring(1)
      case _ => op+value
    }

  def withParens(t: Tree): String = {
    t match {
      case f@ Sum(l, r)   => "("+render(f)+")"
      case f@ Minus(l, r) => "("+render(f)+")"
      case f@_ => render(f)
    }
  }

  def withPowers(l: Tree, r: Tree): String = {

    val lTerm = { l match {case Var(term) => term case _ => ""} }
    val rTerm = { r match {case Var(term) => term case _ => ""} }

    // Case 1 where two vars equal a power2
    if (lTerm == rTerm && !lTerm.isEmpty)
      lTerm+"^2"
    else {
      val lText = withParens(l)
      val rText = withParens(r)
      val reg = """(\w)\^(\d+)""".r
      lText match {
        case reg(term, power) if term == rTerm=> {
          term+"^"+(power.toInt+1).toString()
        }
        case _ => lText+"*"+rText
      }


    }

//    val reg = """(\w)\^(d+)""".r
//    val reg2 = """(\w)*(\w)""".r
//    val lText = withParens(l)
//    lText match {
//      case reg(lterm, power) => {
//        r match {
//          case Var(rterm) if lterm == rterm => lterm + "^" + (power + 1).toString()
//          case _ => lText + "*" + withParens(r)
//        }
//      }
//      case reg2(lterm, rterm) if (lterm == rterm) => lterm+"^2"
//      case _ => lText + "*" + withParens(r)
    }

}
