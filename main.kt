abstract class BankAccount(val accountNumber: Int, val accountHolder: String){
    protected abstract var balance: Double
    abstract fun deposit(amount: Double)
    abstract fun withdraw(amount: Double)
    fun displaybalance(){
        println("Account Holder: $accountHolder")
        println("Account Number: $accountNumber")
        println("Balance: $balance")
    }
}
class SavingsAccount(accountNumber: Int, accountHolder: String, override var balance: Double,val interestRate: Double): BankAccount(accountNumber,accountHolder){
    override fun deposit(amount: Double){
        balance += amount*(1.0-interestRate)
    }

    override fun withdraw(amount: Double) {
        if (balance >= amount){
          balance -= amount
        }
        else {
            println("Insufficient funds!")
        }
    }
}
class CheckingAccount(accountNumber: Int, accountHolder: String, override var balance: Double,val overdraftLimit: Double): BankAccount(accountNumber, accountHolder){
    override fun withdraw(amount: Double) {
        if (-overdraftLimit<=(balance-amount)){
            balance-=amount
        }
        else{
            println("Insufficient funds!")
        }
    }

    override fun deposit(amount: Double) {
        balance+=amount
    }
}
fun main(){
    val a = SavingsAccount(1, "Patrick", 1000000.0, 0.05)
    val b = CheckingAccount(2,"John", 1000000.0, 100000.0)
    a.deposit(100000.0)
    a.displaybalance()
    b.deposit(100000.0)
    b.displaybalance()
    a.withdraw(100000.0)
    a.displaybalance()
    b.withdraw(1250000.0)
    b.displaybalance()
}
