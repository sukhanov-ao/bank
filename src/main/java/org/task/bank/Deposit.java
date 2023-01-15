package org.task.bank;

import java.math.BigDecimal;

public class Deposit extends BankProduct {

    private BigDecimal rateOfInterest;

    public Deposit(String currency, String name, BigDecimal balance, BigDecimal rateOfInterest) {
        super(name, currency, balance);
        this.rateOfInterest = rateOfInterest;
    }

    public BigDecimal getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(BigDecimal rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }


    public void addToDeposit(BigDecimal amountToAdd) {
        this.setBalance(this.getBalance().add(amountToAdd));
    }

    public void close() {
        System.out.println("Вклад успешно закрыт, к выплате: " + balance + " " + currency);
    }
}
