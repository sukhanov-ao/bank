package org.task.bank.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.bank.products.cards.CurrencyDebitCard;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyDebitCardTest {

    private static final Logger log = LoggerFactory.getLogger(CurrencyDebitCardTest.class);
    private static CurrencyDebitCard currencyDebitCard;

    @BeforeEach
    public void prepareCardData() {
        BigDecimal cardBalance = new BigDecimal(1000);
        currencyDebitCard = new CurrencyDebitCard("Валютная", "CNY", cardBalance);
    }

    @Test
    void deposit() {
        BigDecimal depositAmount = new BigDecimal(100);
        currencyDebitCard.deposit(depositAmount);
        assertEquals(currencyDebitCard.getBalance(), new BigDecimal(1100));
        log.info("Баланс на карте равен ожидаемому: " + currencyDebitCard.getBalance() + ", " + 1100);
    }

    @Test
    void debitingFunds() {
        BigDecimal depositAmount = new BigDecimal(100);
        currencyDebitCard.debitingFunds(depositAmount);
        assertEquals(currencyDebitCard.getBalance(), new BigDecimal(900));
        log.info("Баланс на карте равен ожидаемому: " + currencyDebitCard.getBalance() + ", " + 900);
    }

    @Test
    void balanceEnquiry() {
        currencyDebitCard.balanceEnquiry();
    }
}