// first one is an immutable set. This actually creates a new set and reassigns the variable
var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Lear"))
println(jetSet.contains("Airbus"))
println(jetSet.contains("Cessna"))
println(jetSet)


// mutable set
import scala.collection.mutable

val movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)
