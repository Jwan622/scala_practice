/*
Objects are single instances of their own definitions. You can think of them as singletons of their own classes
*/

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

val newId: Int = IdFactory.create()
println(newId) // 1
val newerId: Int = IdFactory.create()
println(newerId)


/*
An object with the same name as a class is called a companion object.
Conversely, the class is the object’s companion class. A companion class or
object can access the private members of its companion. Use a companion object
for methods and values which are not specific to instances of the companion class.
*/

/* The class Circle has a member area which is specific to each instance,
and the singleton object Circle has a method calculateArea which is available
to every instance.
*/

import scala.math._

case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0) //5 to the power of 2 = 25
}

val circle1 = new Circle(5.0)

println(circle1.area)


class Email(val username: String, val domainName: String)

object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}

println(Email.fromString("scala.center@epfl.ch"))
val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
scalaCenterEmail match {
  case Some(email) => println(
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """)
  case None => println("Error: could not parse email")
}
