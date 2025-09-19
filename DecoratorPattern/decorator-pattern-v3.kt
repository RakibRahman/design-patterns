// Beverage interface
interface Beverage {
    fun getDescription(): String
}

// Concrete component
class BasicCoffee : Beverage {
    override fun getDescription() = "Black Coffee"
}

// Base decorator
abstract class BeverageDecorator(private val decoratedBeverage: Beverage) : Beverage {
    override fun getDescription() = decoratedBeverage.getDescription()
}

// Concrete decorator: Milk
class MilkDecorator(beverage: Beverage) : BeverageDecorator(beverage) {
    override fun getDescription() = super.getDescription() + " + Milk"
}

// Concrete decorator: Sugar
class SugarDecorator(beverage: Beverage) : BeverageDecorator(beverage) {
    override fun getDescription() = super.getDescription() + " + Sugar"
}

// Client code
fun main() {
    val coffee = BasicCoffee()
    println(coffee.getDescription())
    // Black Coffee

    val milkCoffee = MilkDecorator(coffee)
    println(milkCoffee.getDescription())
    // Black Coffee + Milk

    val sugarCoffee = SugarDecorator(coffee)
    println(sugarCoffee.getDescription())
    // Black Coffee + Sugar

    val milkSugarCoffee = SugarDecorator(MilkDecorator(coffee))
    println(milkSugarCoffee.getDescription())
    // Black Coffee + Milk + Sugar
}
