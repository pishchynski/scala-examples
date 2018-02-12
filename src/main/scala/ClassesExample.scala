/**
  * Yes, we can just make class without any params and even braces.
  */
class User

/**
  * We can do so
  */
class User1(nameParam: String) {
  val name: String = nameParam

  override def toString: String = s"User1($name)" //  prepending 's' to any string literal allows the usage of variables directly in the string
}

/**
  * By adding the keywords val or var before a class parameter,
  * the class parameter then becomes a field in the class.
  * They're public by default.
  */
class User2(val name: String) {
  override def toString: String = f"User2($name%s)" // simple formatted strings, similar to printf in other languages
}

/**
  * Class with the use of default value
  *
  */
class User3(val name: String = "User Three", var age: Int) {
  override def toString: String = s"User3($name, $age years old)"
}

class User3_1(val name: String, var age: Int = 20) {
  override def toString: String = s"User3_1($name, $age years old)"
}

class User3_2(var age: Int, val name: String = "User Three_2") {
  override def toString: String = s"User3_2($name, $age years old)"
}

/**
  * Class with access modifiers
  */
class User4(private val name: String, protected var age: Int) {
  override def toString: String = s"User4($name, $age years old)"
}

/**
  * Class with the apply method and its overloading
  */
class User5(private val name: String, protected var age: Int) {
  override def toString: String = s"User4($name, $age years old)"

  def apply(newAge: Int): Int = {
    newAge - age
  }

  def apply(pairName: String): String = {
    s"$name + $pairName = <3"
  }
}

class Vehicle {
  def go = "Vehicle goes!"
  override def toString: String = getClass.getName
}

class Car extends Vehicle {
//  override def toString: String = getClass.getName  // returns "Car" either defined or not
}

class Lexus extends Car {
  override def go = "Lexus goes!" // override is necessary anyway!
  override def toString: String = getClass.getName
}


object ClassesExample {
  def main(args: Array[String]): Unit = {
    val user = new User
    println(user)

    val user1 = new User1("User One")
    println(user1)

    val user2 = new User2("User Two")
    println(user2)

    val user3 = new User3(age = 25) // We have to specify which parameter we set, if it's after the default one
    println(user3)

    user3.age += 1
    println(user3)

    val user3_1 = new User3_1("User Three_1")
    println(user3_1)

    val user3_2 = new User3_2(25)
    println(user3_2)

    val user4 = new User4("User Four", 20)
    println(user4)
    // println(user4.name) // Error: value name in class User4 cannot be accessed in User4

    // println(user4.age)  // Error:(73, 19) variable age in class User4 cannot be accessed in User4
    //                     // Access to protected method age not permitted because
    //                     // enclosing object ClassesExample is not a subclass of class User4 where target is defined

    val user5 = new User5("User Five", 20)
    println(user5)
    println("Age difference: " + user5(26))
    println("Age difference: " + user5.apply(26))
    println(user5("Exadel"))

    val vehicle = new Vehicle
    val car = new Car
    val lexus = new Lexus
    println(vehicle)
    println(vehicle.go)

    println(car)
    println(car.go)

    println(lexus)
    println(lexus.go)

  }
}