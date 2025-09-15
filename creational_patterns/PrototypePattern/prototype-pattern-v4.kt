package creational_patterns.PrototypePattern

interface CloneablePrototype<T> {
    fun cloneProfile(): T
}

class CustomerProfile(private var name: String, private var address: String, private val accountNumber: String) :
    CloneablePrototype<CustomerProfile> {

    override fun cloneProfile(): CustomerProfile {
        return CustomerProfile(name, address, accountNumber)
    }

    override fun toString(): String {
        return "CustomerProfile(name='$name', address='$address', accountNumber='$accountNumber')"
    }
}

fun main() {
    val customerOriginal = CustomerProfile("John", "Dhaka", "123098")
    val clonedCustomerProfile = customerOriginal.cloneProfile()
    println("Original: $customerOriginal")
    println("Cloned:   $clonedCustomerProfile")
    println("Are they the same instance? ${customerOriginal === clonedCustomerProfile}") //false
}