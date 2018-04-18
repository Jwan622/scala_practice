import scala.collection.mutable

val treasureMap = mutable.Map[Int, String]()
treasureMap += 1 -> "Go to island."
treasureMap += (2 -> "Find big x on ground")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

// this returns a tuple

println(2 -> "This is a tuple")
