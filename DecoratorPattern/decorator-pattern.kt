package DecoratorPattern

// Interface to define core functionality
interface Car {
    fun assemble(): String
}

// The class that will have dynamic features via decorator
class BasicCar : Car {
    override fun assemble(): String {
        return "BasicCar"
    }
}

// The decorator - acts as a wrapper for Car object
open class CarDecorator(private val decoratedCar: Car) : Car {
    override fun assemble(): String {
        return decoratedCar.assemble()
    }
}

// concrete decorator that add specific features to the BasicCar.
class SportsCar(car: Car) : CarDecorator(car) {
    override fun assemble(): String {
        return super.assemble() + " + Sports Car Features"
    }
}

class LuxuryCar(car: Car) : CarDecorator(car) {
    override fun assemble(): String {
        return super.assemble() + " + Luxury Car Features"
    }
}

fun main() {
    val sportsCar: Car = SportsCar(BasicCar())
    println(sportsCar.assemble()) // Outputs: Basic Car + Sports Car Features

    val luxuryCar: Car = LuxuryCar(BasicCar())
    println(luxuryCar.assemble()) // Outputs: Basic Car + Luxury Car Features
}