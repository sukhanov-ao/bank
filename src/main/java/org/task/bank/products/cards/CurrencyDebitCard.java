package org.task.bank.products.cards;

import java.math.BigDecimal;

public class CurrencyDebitCard extends Card {
    public CurrencyDebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}
