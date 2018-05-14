package shapeless_example

class SomeAction[A, C] (_action: (A, C) => C = (a: A, c: C) => c) {
  def copy(_action: (A, C) => C = this._action): SomeAction[A, C] = {
    new SomeAction[A, C](_action)
  }

  /**
    * Just a copy of OptionDef's  action method
    *
    * @param f action func
    * @return shapeless_example.SomeAction[A, C]
    */
  def action(f: (A, C) => C): SomeAction[A, C] = {
    copy(_action = (a: A, c: C) => {f(a, _action(a, c))})
  }
}