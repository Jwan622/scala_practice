abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int =
    if (height == 0) 0 else contents(0).length

  def above(that: Element): Element =
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element =
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  override def toString = contents mkString " "
}

// new Element
// that won't work here


/*
the above are parameterless methods, quite common. Convention is to use a
parameterless method whenever there are no parameters and the method accesses mutable
state only by reading fields of the containing object. It should not change mutable
state
*/



//extending classes below:
class ArrayElement(
  val contents: Array[String]
) extends Element

val ae = new ArrayElement(Array("hello", "world"))
println(ae.width)

//subtyping below:
val e: Element = new ArrayElement(Array("helloworld"))


// let make new data variants
// layout element with a single line given by a string

class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}

var le = new LineElement("hello-world")
println(le.width)
println(s"Line Element height: ${le.height}")


// polymorphism example

class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  // line is the character to fill with. height is the number of rows.
  def contents = Array.fill(height)(line)
}

// polymorphism right here, conforms to the type of the defined variable
val e1: Element = new ArrayElement(Array("Hello", "World"))
println(e1)
// val ae2: ArrayElement = new LineElement("hello")
val e2: Element = ae
val e3: Element = new UniformElement('J', 2, 3)
println(s"e3: $e3")

var le2 = new ArrayElement(Array("helloooooooo", "hi"))
var le3 = new ArrayElement(Array("booo", "booooooourns"))

var concatted = le2.above(le3)
println(s"above: $concatted")

var ae5 = new ArrayElement(Array("helloooooooo", "hi"))
var ae6 = new ArrayElement(Array("booo", "booooooourns"))

var concatted2 = ae5.beside(ae6)
println(s"beside: $concatted2")

//this next should just be a single zipped line, two words
var ae7 = new ArrayElement(Array("helloooooooo", "hi", "booosadf"))
var le8 = new LineElement("booo")

var concatted3 = ae7.beside(le8)
println(s"beside on 1 line: $concatted3")

