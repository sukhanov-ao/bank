package org.task.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DepositTest {

    private static final Logger log = LoggerFactory.getLogger(DepositTest.class);
    private static Deposit deposit;
    private static BigDecimal rateOfInterest;
    private static BigDecimal depositAmount;

    @BeforeEach
    public void prepareDepositData() {
        rateOfInterest = new BigDecimal(8.3);
        depositAmount = new BigDecimal(100000.0);
        deposit = new Deposit("RUB", "Быстрый", depositAmount, rateOfInterest);
    }

    @Test
    void addToDeposit() {
        BigDecimal amountToAdd = new BigDecimal(10000.0);
        deposit.addToDeposit(amountToAdd);
        assertTrue(deposit.getBalance().equals(new BigDecimal(110000.0)));
        log.info("Вклад успешно пополнен на {}", amountToAdd);
        log.info("Баланс вклада составляет: {} {}", deposit.getBalance(), deposit.getCurrency());
    }

    @Test
    void close() {
        deposit.close();
    }
}