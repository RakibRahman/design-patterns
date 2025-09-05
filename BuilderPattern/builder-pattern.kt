package BuilderPattern

data class House(
    val rooms: Int,
    val bathrooms: Int,
    val hasGarage: Boolean = false,
    val hasSwimmingPool: Boolean = false,
    val hasGarden: Boolean = false
    )


class HouseBuilder(private var rooms: Int,private var bathrooms: Int){
    private var hasGarage: Boolean = false
    private var hasGarden: Boolean = false
    private var hasSwimmingPool: Boolean = false

    fun setGarage(value: Boolean) = apply { hasGarage = value } //  Method chaining is enabled using Kotlin’s apply.
    fun setSwimmingPool(value: Boolean) = apply { hasSwimmingPool = value }
    fun setGarden(value: Boolean) = apply { hasGarden = value }

    fun build() = House(rooms,bathrooms,hasGarage,hasSwimmingPool,hasGarden)
}

fun main(){
    val house = HouseBuilder(4,2).setGarden(true).setSwimmingPool(true).build()
    println("The house has ${house.rooms} rooms and ${house.bathrooms} bathrooms")
}