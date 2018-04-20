// rational with auxiliary constructor:

class Rational(n: Int, d: Int) {
  require(d != 0)

  val numer: Int = n
  val denom: Int = d

  def this(n: Int) = this(n,1) //auxiliary constructor

  override def toString = numer + "/" + denom

  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
}

val y = new Rational(3)
println(y)
// usage of private fields and methods


/* classes with private fields */
// right now rational is not normalized to GCD. Let's implement that

class Rational1(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n/g
  val denom = d/g

  def this(n: Int) = this(n,1) //auxiliary constructor

  override def toString = numer + "/" + denom

  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

val z = new Rational1(12, 6)
println(z)


// defining our own operators

class Rational2(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n/g
  val denom = d/g

  def this(n: Int) = this(n,1) //auxiliary constructor

  def + (that: Rational2): Rational2 =
    new Rational2(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that: Rational2): Rational2 = {
    new Rational2(numer * that.numer, denom * that.denom)
  }

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

val a = new Rational2(1,2)
val b = new Rational2(2,3)

println(a + b)

// method overloading

class Rational3(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n/g
  val denom = d/g

  def this(n: Int) = this(n,1) //auxiliary constructor

  def + (that: Rational3): Rational3 =
    new Rational3(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational3 =
    new Rational3(numer + i * denom, denom)

  def - (that: Rational3): Rational3 =
    new Rational3(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational3 =
    new Rational3(numer - i * denom, denom)

  def * (that: Rational3): Rational3 = {
    new Rational3(numer * that.numer, denom * that.denom)
  }

  def * (i: Int): Rational3 =
    new Rational3(numer * i, denom)

  def / (that: Rational3): Rational3 =
    new Rational3(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational3 =
    new Rational3(numer, denom * i)

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

var rat3 = new Rational3(2,3)
println(rat3)
println(rat3 * rat3)
println(rat3 * 3)

// lets get 2 * Rational to work

implicit def intToRational(x: Int) = new Rational3(x)
println(2 * new Rational3(2,3))
