import exception.InsufficientFundsException;

public class BankAccountTransaction {

    public void deposit(BankAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(BankAccount account, double amount) {
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Not enough balance in bank account.");
        }
        account.setBalance(account.getBalance() - amount);
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        withdraw(from, amount);
        deposit(to, amount);
    }

    public double getBankAccountBalance(BankAccount account) {
        return account.getBalance();
    }
}
