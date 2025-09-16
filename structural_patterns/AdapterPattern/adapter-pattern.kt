package structural_patterns.AdapterPattern

// Target Interface - interface the client expects to interact with.
interface USB {
    fun connectWithUsbCable()
}

// Adaptee - the existing class with an incompatible interface that needs to be adapted.
// The adaptee class has method `connectWithMicroUsbCable` which is not compatible with `USB` interface.
class MicroUSB {
    fun connectWithMicroUsbCable() {
        println("Connected with MicroUSB cable.")
    }
}

// The adapter class implements the target interface and internally uses an instance of the adaptee class.
class Adapter(private val microUSB: MicroUSB) : USB {
// translates the connectWithUsbCable call into connectWithMicroUsbCable.
    override fun connectWithUsbCable() {
        microUSB.connectWithMicroUsbCable()
    }
}

fun main() {
    val microUSB = MicroUSB()
    val adapter = Adapter(microUSB)
    adapter.connectWithUsbCable() // Outputs: Connected with MicroUSB cable.
}