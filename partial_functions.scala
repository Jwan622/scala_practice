val root: PartialFunction[Double,Double] = {
  case d if (d >= 0) => math.sqrt(d)
}

root.isDefinedAt(-1)

root(3)

def plus(a: Int)(b: Int) = a + b
def plus2 = plus(2)(_)
// plus 2 = def plus(b: Int) = 2 + b

plus2(2)
plus2(3)

def wrap(prefix: String)(html: String)(suffix: String) = {
    prefix + html + suffix
}
val wrapWithDiv = wrap("<div>")(_: String)("</div>")
wrapWithDiv("<p>Hello, world</p>")
wrapWithDiv("<img src=\"/images/foo.png\" />")


// curried from regular functions
def add(x: Int, y: Int) = x + y
val addFunction = add _
addFunction(1,2)
