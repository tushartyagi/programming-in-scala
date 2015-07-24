trait Flyer {
  def fly() = println("I fly")
}
class Bird(val name: String, val food: String)
  extends Flyer with Living{
}
val pigeon = new Bird("Pigeon", "Daana")
pigeon.fly()
pigeon.eat()
trait Living {
  def food: String
  def eat() =
    println("I am eating " + food)
}

