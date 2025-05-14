package model;

import java.util.ArrayList;
import java.util.List;

public class CardHolder {
        // Անձնագրի համարը
        private String passportNumber;

        // Ամբողջական անուն
        private String fullName;

        // Բնակության հասցեն (Օբյեկտ Address դասից)
        private Address address;

        // Քարտերի ցուցակ (մեկ անձ կարող է ունենալ մինչև 3 քարտ)
        private List<CardAccount> cardAccounts;

        // Մեկ բանկային հաշիվ
        private BankAccount bankAccount;

        // Կոնստրուկտոր՝ քարտերի ցուցակը սկզբնականացնում ենք դատարկ List-ով
        public CardHolder() {
                this.cardAccounts = new ArrayList<>();
        }

        // Getter / Setter մեթոդներ

        public String getPassportNumber() {
                return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
                this.passportNumber = passportNumber;
        }

        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
        }

        public Address getAddress() {
                return address;
        }

        public void setAddress(Address address) {
                this.address = address;
        }

        public List<CardAccount> getCardAccounts() {
                return cardAccounts;
        }

        public void setCardAccounts(List<CardAccount> cardAccounts) {
                this.cardAccounts = cardAccounts;
        }

        public BankAccount getBankAccount() {
                return bankAccount;
        }

        public void setBankAccount(BankAccount bankAccount) {
                this.bankAccount = bankAccount;
        }

        // Օգնական մեթոդ՝ քարտ ավելացնելու համար
        public boolean addCard(CardAccount card) {
                if (cardAccounts.size() >= 3) {
                        return false; // Չի կարելի ավելացնել ավել քան 3 քարտ
                }
                cardAccounts.add(card);
                return true;
        }
}



