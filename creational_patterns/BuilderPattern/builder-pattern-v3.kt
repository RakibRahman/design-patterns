import creational_patterns.BuilderPattern.House

class BankAccount private constructor(
    val accountNumber: String,
    val balance: Double,
    val hasOverdraftProtection: Boolean,
    val allowsInternationalTransactions: Boolean,
    val hasOnlineBankingAccess: Boolean
) {

    class AccountBuilder(private val accountNumber: String, private val balance: Double) {
        private var allowsInternationalTransactions = false
        private var hasOnlineBankingAccess = false
        private var hasOverdraftProtection = false

        fun setAllowsInternationalTransactions(value: Boolean) = apply {
            allowsInternationalTransactions = value
        }

        fun setHasOnlineBankingAccess(value: Boolean) = apply {
            hasOnlineBankingAccess = value
        }

        fun setHasOverdraftProtection(value: Boolean) = apply {
            hasOverdraftProtection = value
        }

        fun build(): BankAccount {
            return BankAccount(
                accountNumber,
                balance,
                hasOverdraftProtection,
                allowsInternationalTransactions,
                hasOnlineBankingAccess
            )
        }
    }

    override fun toString(): String {
        return "BankAccount(accountNumber='$accountNumber', balance=$balance, " +
                "Overdraft Protection=$hasOverdraftProtection, " +
                "International Transactions=$allowsInternationalTransactions, " +
                "Online Banking Access=$hasOnlineBankingAccess)"
    }
}

fun main() {
    val account =
        BankAccount.AccountBuilder("123456789", 1000.00)
            .setHasOverdraftProtection(true)
            .setHasOnlineBankingAccess(true)
            .setAllowsInternationalTransactions(true).build()

    println(account)
}