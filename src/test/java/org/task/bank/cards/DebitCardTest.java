package org.task.bank.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.task.bank.DebitCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {

    private static final Logger log = LoggerFactory.getLogger(DebitCardTest.class);
    private static DebitCard debitCard;

    @BeforeEach
    public void prepareCardData() {
        BigDecimal cardBalance = new BigDecimal(1000);
        debitCard = new DebitCard("Молодежная", "RUB", cardBalance);
    }

    @Test
    void deposit() {
        BigDecimal depositAmount = new BigDecimal(100);
        debitCard.deposit(depositAmount);
        assertTrue(debitCard.getBalance().equals(new BigDecimal(1100)));
        log.info("Баланс на карте равен ожидаемому и составляет {} {}", debitCard.getBalance(), debitCard.getCurrency());
    }

    @Test
    void debitingFunds() {
        BigDecimal depositAmount = new BigDecimal(100);
        debitCard.debitingFunds(depositAmount);
        assertTrue(debitCard.getBalance().equals(new BigDecimal(900)));
        log.info("Баланс на карте равен ожидаемому и составляет {} {}", debitCard.getBalance(), debitCard.getCurrency());
    }

    @Test
    void balanceEnquiry() {
        debitCard.balanceEnquiry();
    }
}