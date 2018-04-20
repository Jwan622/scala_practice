// trait Greeter {
//   def greet(name: String): Unit
// }


// Traits can also have default implementations.

trait Greeter1 {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

// You can extend traits with the extends keyword and override an implementation with the override keyword.

class DefaultGreeter extends Greeter1

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter1 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeter = new DefaultGreeter()
greeter.greet("Scala developer") // Hello, Scala developer!

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer") // How are you, Scala developer?

// generic types with abstract methods:

trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}

/*
Extending the trait Iterator[A] requires a type A and implementations of
the methods hasNext and next.
*/
class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}
val iterator = new IntIterator(5)
println(iterator.next())
println(iterator.next())
println(iterator.next())
println(iterator.next())
println(iterator.next())
println(iterator.next())
