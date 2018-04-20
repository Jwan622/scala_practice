case class User(val name: String, val age: Int)


val userBase = List(new User("Travis", 28),
  new User("Kelly", 33),
  new User("Jennifer", 44),
  new User("Dennis", 23))
/*
Comprehensions have the form for (enumerators) yield e, where enumerators
refers to a semicolon-separated list of enumerators. An enumerator is either
a generator which introduces new variables, or it is a filter.
*/

// user <- userBase is our generator
val twentySomethings = for (user <- userBase if (user.age >=20 && user.age < 30))
  yield user.name  // i.e. add this to a list

twentySomethings.foreach(name => println(name))  // prints Travis Dennis

// these enumerators are separated by a semi-colon. i <- 0 until n is a single enumerator and is a generator.
def foo(n: Int, v: Int) =
   for (i <- 0 until n;
        j <- i until n if i + j == v)
   yield (i, j)

foo(10, 10) foreach {
  case (i, j) =>
    print(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
}


def foo2(n: Int, v: Int) =
   for (i <- 0 until n;
        j <- i until n if i + j == v)
   print(s"($i, $j)")

foo2(10, 10)
