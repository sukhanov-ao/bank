package org.task.bank.products.cards;

import org.task.bank.products.BankProduct;

import java.math.BigDecimal;

public abstract class Card extends BankProduct {

    public Card(String currency, String name, BigDecimal balance) {
        super(currency, name, balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal depositAmount) {
        this.setBalance(this.getBalance().add(depositAmount));
    }

    public void debitingFunds(BigDecimal debitAmount) {
        this.setBalance(this.getBalance().subtract(debitAmount));
    }

    public void balanceEnquiry() {
        System.out.println("Баланс по карте составляет: " + this.getBalance() + " " + this.getCurrency());
    }

}
