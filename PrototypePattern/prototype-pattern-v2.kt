package PrototypePattern

data class Address(var street: String, var city: String)

data class Person(val name: String, private val addresses: MutableList<Address>) {
    fun addAddress(address: Address) {
        addresses.add(address)
    }

    fun getAddresses(): List<Address> = addresses

    fun copy(): Person {
        // TODO: Implement deep copy of the addresses list
        return Person(name, addresses)
    }

    override fun toString(): String {
        return "Person(name='$name', addresses=$addresses)"
    }
}

fun main() {
    // Original person
    val originalPerson = Person("John Doe", mutableListOf())
    originalPerson.addAddress(Address("123 Main St", "New York"))
    originalPerson.addAddress(Address("456 Elm St", "Boston"))

    val clonedPerson = originalPerson.copy()

    clonedPerson.getAddresses()[0].street = "789 Oak St"

    println("Original Person: $originalPerson")
    println("Cloned Person: $clonedPerson")
}