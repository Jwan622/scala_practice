// proves that all of these elements of the list are of a type.
//  are instance of scala.Any

val list: List[Any] = List(
  "a string",
  732,  // an integer
  'c',  // a character
  true, // a boolean value
  () => "an anonymous function returning a string"
)

list.foreach(element => println(element))


trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class Motorcycle extends Vehicle
class Vegetable
class Bicycle extends Vehicle
class Tricycle extends Bicycle

class Parking[A](val place: A)

new Parking[Motorcycle](new Motorcycle)

// jeep is a subtype of car so this is OK
new Parking[Car](new Jeep)

class Parking[A >: Bicycle <: Vehicle](val plaza: A)

new Parking(new Bicycle)
new Parking(new Vehicle)
new Parking(new Coupe)
new Parking(new Tricycle)
