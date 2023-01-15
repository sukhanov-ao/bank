package org.task.bank;

import java.math.BigDecimal;

public class CurrencyDebitCard extends Card {
    public CurrencyDebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}
