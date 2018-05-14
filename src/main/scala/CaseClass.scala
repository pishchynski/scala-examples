import reflect._
import scala.reflect.runtime.universe._
import scala.reflect.runtime._

object CaseClassExample {

  object CaseClassCopier {
    val mirror = universe.runtimeMirror(getClass.getClassLoader)

    def updateParam[C: ClassTag](c: C, paramName: String, paramValue: Any): C = {
      val instanceMirror = mirror.reflect(c)
      val instanceType = instanceMirror.symbol.asType.toType
      val members = instanceType.members
        .map(method => transformMethod(method, paramName, paramValue, instanceMirror))
        .filter(_ != None)
        .toArray
        .reverse

      val copyMethod = instanceType.decl(TermName("copy")).asMethod
      val copyMethodInstance = instanceMirror.reflectMethod(copyMethod)

      copyMethodInstance(members: _*).asInstanceOf[C]
    }

    def transformMethod(method: Symbol, paramName: String, paramValue: Any, instanceMirror: InstanceMirror): Any = {
      val term = method.asTerm
      if (term.isAccessor) {
        println(term.name + " true")
        if (term.name.toString == paramName) {
          println("Name equals")
          paramValue
        } else {
          instanceMirror.reflectField(term).get
        }
      } else {
        None
      }
    }
  }

  case class CaseClass(var x: Int)

  def main(args: Array[String]): Unit = {
    val cc = CaseClass(1)

    val cc2 = CaseClassCopier.updateParam(cc, "x", 5)
    print(cc2)
  }
}