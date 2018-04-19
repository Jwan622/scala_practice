trait Greeter {
  def greet(name: String): Unit
}


// Traits can also have default implementations.

trait Greeter {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}


// You can extend traits with the extends keyword and override an implementation with the override keyword.

class DefaultGreeter extends Greeter

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeter = new DefaultGreeter()
greeter.greet("Scala developer") // Hello, Scala developer!

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer") // How are you, Scala developer?
