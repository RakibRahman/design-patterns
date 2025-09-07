package PrototypePattern

import Prototype


data class Address(var street: String, var city: String){
    fun copy(): Address = Address(street,city)
}

data class Person(val name: String, private val addresses: MutableList<Address>):Prototype<Person> {
    fun addAddress(address: Address) {
        addresses.add(address)
    }

    fun getAddresses(): List<Address> = addresses

    override fun clone(): Person {
       val deepCopyAddresses = addresses.map { it.copy()}.toMutableList()
        return Person(name, deepCopyAddresses)
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

    val clonedPerson = originalPerson.clone()

    clonedPerson.getAddresses()[0].street = "Uttara"

    println("Original Person: $originalPerson")
    println("Cloned Person: $clonedPerson")
}