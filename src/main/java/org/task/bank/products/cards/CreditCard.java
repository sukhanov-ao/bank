package org.task.bank.products.cards;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCard extends Card {

    private BigDecimal rateOfInterest;

    public CreditCard(String currency, String name, BigDecimal balance, BigDecimal rateOfInterest) {
        super(currency, name, balance);
        this.rateOfInterest = rateOfInterest;
    }

    public BigDecimal getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(BigDecimal rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public BigDecimal getOverdueAmount(Double moneyUsed, Integer monthsPassed) {
        BigDecimal percent = rateOfInterest.divide(BigDecimal.valueOf(100), 2, RoundingMode.DOWN);
        return BigDecimal.valueOf(moneyUsed)
                .multiply(percent.divide(new BigDecimal(12), 4, RoundingMode.HALF_EVEN)
                        .multiply(BigDecimal.valueOf(monthsPassed)));
    }

    @Override
    public void deposit(BigDecimal depositAmount) {
        super.setBalance(super.getBalance().add(depositAmount));
    }

    @Override
    public void debitingFunds(BigDecimal debitAmount) {
        super.setBalance(super.getBalance().subtract(debitAmount));
    }
}
