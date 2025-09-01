enum class CRUST{THIN,THICK,STUFFED}
enum class SIZE {
    SMALL, MEDIUM, LARGE
}

data class Pizza(
    val size: SIZE,
    val crust: CRUST,
    val toppings: MutableList<String> = mutableListOf(),
    val cheese: Boolean = true
)

class PizzaBuilder(private var size: SIZE,private var crust:CRUST){
    private var toppings: MutableList<String> = mutableListOf("mushroom","capsicum")
    private var cheese: Boolean = true

    fun addTopping(value: String) = apply{
        toppings.add(value)
    }

    fun setCheese(value: Boolean) = apply {
        cheese = value
    }
    fun build() = Pizza(size,crust,toppings,cheese)
}

fun main() {
    val largePizza = PizzaBuilder(SIZE.LARGE, CRUST.THICK).setCheese(false).addTopping("chicken").addTopping("chilli").build()
    println("Size: ${largePizza.size}, Crust: ${largePizza.crust}, Toppings: ${largePizza.toppings}, Cheese: ${largePizza.cheese}")
}