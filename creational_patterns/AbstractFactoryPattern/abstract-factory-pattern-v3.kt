abstract class Loan(protected val interestRate: Double, protected val loanAmount: Double) {
    abstract fun loanDetails()
}

class HomeLoan(interestRate: Double, loanAmount: Double) : Loan(interestRate, loanAmount) {
    override fun loanDetails() {
        println("Home Loan: $loanAmount - interestRate: $interestRate")
    }
}


class CarLoan(interestRate: Double, loanAmount: Double) : Loan(interestRate, loanAmount) {
    override fun loanDetails() {
        println("Car Loan: $loanAmount - interestRate: $interestRate")
    }
}

interface LoanFactory {
    fun createLoan(interestRate: Double, loanAmount: Double): Loan
}


class HomeLoanFactory : LoanFactory {
    override fun createLoan(interestRate: Double, loanAmount: Double): Loan {
        return HomeLoan(interestRate, loanAmount)
    }
}

class CarLoanFactory : LoanFactory {
    override fun createLoan(interestRate: Double, loanAmount: Double): Loan {
        return CarLoan(interestRate, loanAmount)
    }
}

class LoanApplication {

    fun applyForLoan(factory: LoanFactory, interestRate: Double, loanAmount: Double): Loan {
        return factory.createLoan(interestRate, loanAmount)
    }
}

fun main() {
    val application = LoanApplication()

    val homeLoan = application.applyForLoan(HomeLoanFactory(), 6.5, 500000.0)
    val carLoan = application.applyForLoan(CarLoanFactory(), 8.0, 20000.0)

    homeLoan.loanDetails()
    carLoan.loanDetails()
}