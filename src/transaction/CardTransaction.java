package transaction;

import exception.InsufficientFundsException;

public class CardTransaction {

    public void deposit(CardAccount card, double amount) {
        if (card == null || card.getCardStatus() == CardStatus.BLOCKED) {
            System.out.println("Cannot deposit: Card is not active or not found.");
            return;
        }
        card.setBalance(card.getBalance() + amount);
    }

    public void withdraw(CardAccount card, double amount) {
        if (card.getCardStatus() == CardStatus.BLOCKED) {
            throw new IllegalStateException("Card is blocked.");
        }
        if (card.getBalance() < amount) {
            throw new InsufficientFundsException("Not enough balance.");
        }
        card.setBalance(card.getBalance() - amount);
    }

    public void transfer(CardAccount from, CardAccount to, double amount) {
        withdraw(from, amount);
        deposit(to, amount);
    }

    public void addCard(CardHolder holder, CardAccount card) {
        if (holder.getCardAccounts().size() >= 3) {
            System.out.println("Cannot add more than 3 cards.");
            return;
        }
        holder.getCardAccounts().add(card);
    }

    public void blockCard(CardAccount card) {
        card.setCardStatus(CardStatus.BLOCKED);
    }

    public double getCardBalance(CardAccount card) {
        return card.getBalance();
    }
}
