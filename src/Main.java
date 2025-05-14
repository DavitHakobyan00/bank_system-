import enums.CardType;
import enums.Currency;
import model.Address;
import model.BankAccount;
import model.CardAccount;
import model.CardHolder;
import transaction.CardTransaction;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Armenia", "Yerevan", "Yerevan", "Abovyan", "15A");
        Address address2 = new Address("Armenia", "Lori", "Vanadzor", "Tigran Mets", "12");

        CardHolder holder1 = new CardHolder("AB123456", "Karen Sargsyan", address1);
        CardHolder holder2 = new CardHolder("XY789012", "Ani Mkrtchyan", address2);

        BankAccount account1 = new BankAccount("1234567812345678", 0, Currency.AMD);
        BankAccount account2 = new BankAccount("8765432187654321", 0, Currency.AMD);

        holder1.setBankAccount(account1);
        holder2.setBankAccount(account2);

        CardAccount card1 = new CardAccount("1111222233334444", "123", "12/28", CardType.VISA, 0, CardStatus.ACTIVE, Currency.AMD);
        CardAccount card2 = new CardAccount("5555666677778888", "456", "01/29", CardType.MASTERCARD, 0, CardStatus.ACTIVE, Currency.AMD);

        CardTransaction cardTransaction = new CardTransaction();
        cardTransaction.addCard(holder1, card1);
        cardTransaction.addCard(holder2, card2);

        bankAccountTransaction bankTx = new bankAccountTransaction();
        bankTx.deposit(account1, 100000);
        bankTx.deposit(account2, 50000);

        cardTransaction.deposit(card1, 20000);
        cardTransaction.deposit(card2, 15000);

        try {
            cardTransaction.withdraw(card1, 30000); // Trigger exception
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        cardTransaction.transfer(card1, card2, 5000);
        bankTx.transfer(account1, account2, 10000);

        System.out.println("Final balances:");
        System.out.println("Card1: " + cardTransaction.getCardBalance(card1));
        System.out.println("Card2: " + cardTransaction.getCardBalance(card2));
        System.out.println("Account1: " + bankTx.getBankAccountBalance(account1));
        System.out.println("Account2: " + bankTx.getBankAccountBalance(account2));
    }
}
