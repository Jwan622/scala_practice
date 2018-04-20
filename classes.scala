// class ChecksumAccumulator {
//   private var sum = 0
//
//   def add(b: Byte): Unit = {
//     sum += b
//   }
//
//   def checksum(): Int = {
//     return ~(sum & 0xFF) + 1
//   }
// }

// The above is the same as:

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

var cs = new ChecksumAccumulator
var firstSum = cs.checksum()
println(firstSum)
cs.add(3)
var sum = cs.checksum()
println(sum)


class User

/*
The keyword new is used to create an instance of the class. User has a
default constructor which takes no arguments because no constructor was defined.
However, you’ll often want a constructor and class body. Here is an
example class definition for a point:
*/
val user1 = new User


class Point(var x: Int, var y: Int) {

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String =
    s"($x, $y)"
}

/*
his Point class has four members: the variables x and y and the methods move
and toString. Unlike many other languages, the primary constructor is in the
class signature (var x: Int, var y: Int)
*/
val point1 = new Point(2, 3)
println(point1.x)  // 2
println(point1)
point1.move(4,5)
println(point1.x)
println(point1)


// Constructors can have optional parameters by providing a default value like so:

class Point2(var x: Int = 0, var y: Int = 0)

val origin = new Point2  // x and y are both set to 0
val point2 = new Point2(1)
println("origin x:" + origin.x)
println("point2 x:" + point2.x)  // prints 1


class Point3(var x: Int = 0, var y: Int = 0)
val point3 = new Point3(y=2)
println("point3 y:" + point3.y)  // prints 2



// getters and setters
class Point4 {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

val point4 = new Point4
point4.x = 99
point4.y = 101 // prints the warning
