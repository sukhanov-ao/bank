package org.task.bank.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.bank.products.cards.CreditCard;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    private static final Logger log = LoggerFactory.getLogger(CreditCardTest.class);
    private static CreditCard creditCard;
    private static BigDecimal rateOfInterest;

    @BeforeEach
    public void prepareCardData() {
        BigDecimal cardBalance = new BigDecimal(1000);
        rateOfInterest = new BigDecimal(8);
        creditCard = new CreditCard("RUB", "Кредитная", cardBalance, rateOfInterest);
    }

    @Test
    void deposit() {
        BigDecimal depositAmount = new BigDecimal(100);
        creditCard.deposit(depositAmount);
        assertTrue(creditCard.getBalance().equals(new BigDecimal(1100)));
        log.info("Баланс на карте равен ожидаемому и составляет {} {}", creditCard.getBalance(), creditCard.getCurrency());
    }

    @Test
    void debitingFunds() {
        BigDecimal depositAmount = new BigDecimal(100);
        creditCard.debitingFunds(depositAmount);
        assertTrue(creditCard.getBalance().equals(new BigDecimal(900)));
        log.info("Баланс на карте равен ожидаемому и составляет {} {}", creditCard.getBalance(), creditCard.getCurrency());
    }

    @Test
    void calculateOverdueAmount() {
        Integer monthsPassed = 8;
        Double moneyUsed = 100.0;
        BigDecimal overdueAmount = creditCard.getOverdueAmount(moneyUsed, monthsPassed);
        log.info("Задолженность составляет {}", overdueAmount);
    }

    @Test
    void balanceEnquiry() {
        creditCard.balanceEnquiry();
    }
}