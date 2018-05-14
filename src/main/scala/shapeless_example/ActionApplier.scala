package shapeless_example

import shapeless.lens
import scala.reflect.ClassTag

class ActionApplier[C] {
//  def changeSomeAction[T](paramName: String)(implicit classTag: ClassTag[C]): SomeAction[T, C] = {
//    val someAction = new SomeAction[T, C]()
//    someAction.action ((x, c) => {
//      val paramLens = lens[C] >> Symbol(paramName)
//      paramLens.set(c)(x)
//    })
//  }
}
