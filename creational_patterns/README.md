# design-patterns

# Singleton Pattern
The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance.
Ensure that only one instance of the class exists by using the `object` declaration in kotlin.
The Singleton pattern is crucial because it helps you manage shared resources more efficiently. For example, think of scenarios like logging, configuration settings, or database connections — these are areas where you typically need only one instance.


# Factory Pattern
The Factory Method pattern is a creational design pattern that provides an interface for creating objects in a superclass, but it allows subclasses to alter the type of objects that will be created. Instead of calling a constructor directly to create an object, the client calls a factory method defined by an abstract class or interface, which delegates the process to derived classes. This approach promotes loose coupling and adheres to the Open/Closed Principle, allowing a system to be extended without modifying existing code.
Let a subclass decide what to create.

# Abstract Factory pattern 
A design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

The Abstract Factory pattern is a way to create families of related objects without having to specify their exact classes. Think of it as a "factory for factories."

Key Points
    Creates Families of Objects: Instead of creating a single object (like one button), this pattern is designed to create a whole set of objects that are meant to work together. For example, it could create a button, a checkbox, and a window that all share the same visual style (e.g., a "dark mode" theme).

    Uses Composition: It delegates the job of creating objects to other, more specialized factory objects. Imagine a BuilderPattern.AbstractFactoryPattern.creational_patterns.main furniture factory (the Abstract Factory) that doesn't make furniture itself. Instead, it has contracts with a "Modern Style" factory and a "Vintage Style" factory. When you want a modern chair, you ask the BuilderPattern.AbstractFactoryPattern.creational_patterns.main factory, and it tells the modern factory to make it for you.

    Manages Complexity: This pattern is perfect for systems that need to support multiple "themes" or configurations. For instance, an application that can switch between a Windows look, a macOS look, and a Linux look would use an abstract factory to ensure all UI elements match the chosen operating system's style.

    Enhances Scalability: Adding a new family of objects is easy. If you wanted to add a "futuristic" theme to your UI, you would simply create a new "futuristic factory" without having to change the existing code that requests the UI elements.

# Builder Pattern
A creational pattern that helps you construct complex objects, step by step, in a readable and manageable way. Its  simplifies the creation of complex objects.

# Prototype Pattern
A design pattern that lets create a new objects by copying existing  ones. It allows efficient and consistent replication of objects.


# Implementing the three design patterns — Singleton, Factory, and Builder

```angular2html
object DatabaseConnection {
fun connect() {
println("Connected to the database.")
logConnection()
}

private fun logConnection() {
val connectionTime = java.time.LocalDateTime.now()
println("Connected to the database at $connectionTime")
}
        }

abstract class BankAccount(
protected var accountNumber: String,
protected var balance: Double,
protected val accountType: String
) {
abstract fun accountDetails()
}

class SavingsAccount(accountNumber: String, balance: Double, accountType: String) :
BankAccount(accountNumber, balance, accountType) {

override fun accountDetails() {
println("Savings Account [Account Number=$accountNumber, Balance=$balance], AccountType=$accountType")
}
        }

class CheckingAccount(accountNumber: String, balance: Double, accountType: String) :
BankAccount(accountNumber, balance, accountType) {

override fun accountDetails() {
println("Checking Account [Account Number=$accountNumber, Balance=$balance], AccountType=$accountType")
}
        }

fun createAccount(type: String, accountNumber: String, balance: Double): BankAccount {
return when (type) {
"Savings" -> SavingsAccount(accountNumber, balance, type)
"Checking" -> CheckingAccount(accountNumber, balance, type)
else -> throw IllegalArgumentException("Unknown account type: $type")
}
        }

data class LoanApplication private constructor(
val applicantName: String,
val loanAmount: Double,
val termLength: Int,
val collateral: String?,
val interestRate: Double = 0.0,
) {
class Builder(private val applicantName: String, private val loanAmount: Double) {
private var termLength = 0
private var collateral: String? = null
private var interestRate = 0.0

fun withTermLength(termLength: Int) = apply { this.termLength = termLength }
fun withCollateral(collateral: String?) = apply { this.collateral = collateral }
fun withInterestRate(rate: Double) = apply { this.interestRate = rate }

fun build() = LoanApplication(applicantName, loanAmount, termLength, collateral, interestRate)
}

override fun toString(): String {
return "LoanApplication [Applicant Name=$applicantName, Loan Amount=$loanAmount, Term Length=$termLength years, Collateral=$collateral, InterestRate=$interestRate]"
}
        }

fun main() {
DatabaseConnection.connect()

val savingsAccount = createAccount("Savings", "123456", 1000.00)
val checkingAccount = createAccount("Checking", "654321", 500.00)
val businessAccount = createAccount("Business", "24321", 900.00)

savingsAccount.accountDetails()
checkingAccount.accountDetails()
businessAccount.accountDetails()

val loanApplication = LoanApplication.Builder("Alice", 50000.00)
.withTermLength(15)
.withCollateral("House")
.withInterestRate(5.00)
.build()
println(loanApplication)
}
```