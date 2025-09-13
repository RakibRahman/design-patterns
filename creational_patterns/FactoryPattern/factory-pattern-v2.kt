package creational_patterns.FactoryPattern

// Abstract class for BankAccount
abstract class BankAccount(
    protected val accountNumber: Int,
    private var balance: Int
) {
    abstract fun accountType()
}

// SavingsAccount implementation
class SavingsAccount(accountNumber: Int, balance: Int) : BankAccount(accountNumber, balance) {
    override fun accountType() {
        println("This is a Savings Account")
    }
}

// CheckingAccount implementation
class CheckingAccount(accountNumber: Int, balance: Int) : BankAccount(accountNumber, balance) {
    override fun accountType() {
        println("This is a Checking Account")
    }
}

// Factory object
object BankAccountFactory {
    enum class AccountType {
        SAVINGS, CHECKING
    }

    fun createAccount(accountType: AccountType, accountNumber: Int, balance: Int): BankAccount =
        when (accountType) {
            AccountType.SAVINGS -> SavingsAccount(accountNumber, balance)
            AccountType.CHECKING -> CheckingAccount(accountNumber, balance)
        }
}

fun main() {
    // Create a SavingsAccount
    val savingsAccount = BankAccountFactory.createAccount(
        BankAccountFactory.AccountType.SAVINGS,
        111,
        345
    )
    savingsAccount.accountType() // Output: This is a Savings Account

    // Create a CheckingAccount
    val checkingAccount = BankAccountFactory.createAccount(
        BankAccountFactory.AccountType.CHECKING,
        221,
        3785
    )
    checkingAccount.accountType() // Output: This is a Checking Account
}
