// Generic Prototype interface that defines the contract for cloning objects.
interface Prototype<T> {
    fun clone(): T
}

// Abstract base class for PCs implementing Prototype
abstract class PC(open val cpu: String) : Prototype<PC> {
    abstract override fun clone(): PC
}

// Concrete Desktop class using data class for easy cloning
data class Desktop(override val cpu: String, val motherboard: String) : PC(cpu) {
    // Use data class copy method for cloning
    override fun clone(): Desktop = copy()
}

fun main() {
    // Original desktop object
    val originalDesktop = Desktop("Intel Core i9", "MSI B450")

    // Clone the original desktop
    val clonedDesktop = originalDesktop.clone()

    println("Original Desktop - CPU: ${originalDesktop.cpu}, Motherboard: ${originalDesktop.motherboard}")
    // Original Desktop - CPU: Intel Core i9, Motherboard: MSI B450
    println("Cloned Desktop   - CPU: ${clonedDesktop.cpu}, Motherboard: ${clonedDesktop.motherboard}")
    // Cloned Desktop   - CPU: Intel Core i9, Motherboard: MSI B450

    // Check equality (data class automatically implements equals)
    println("Are original and cloned equal? ${originalDesktop == clonedDesktop}")

    // Modifying clone does not affect the original
    val modifiedClone = clonedDesktop.copy(cpu = "AMD Ryzen 9")
    println("Modified Clone - CPU: ${modifiedClone.cpu}, Motherboard: ${modifiedClone.motherboard}")
    println("Original after clone modification - CPU: ${originalDesktop.cpu}")
}
