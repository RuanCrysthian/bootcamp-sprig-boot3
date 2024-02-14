package org.example.entities;

import org.example.factories.AccountFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
    double amount = 200;
    double expectedValue = 196.0;

    Account account = AccountFactory.createEmptyAccount();

    account.deposit(amount);
    Assertions.assertEquals(expectedValue, account.getBalance());
  }

  @Test
  void depositShouldDoNothingWhenNegativeAmount() {
    double expectedValue = 100.0;
    Account account = AccountFactory.createAccount(expectedValue);
    double amount = -200.0;

    account.deposit(amount);

    Assertions.assertEquals(expectedValue, account.getBalance());
  }

  @Test
  void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
    double expectedValue = 0.0;
    double initialBalance = 800;
    Account account = AccountFactory.createAccount(initialBalance);

    double result = account.fullWithdraw();

    Assertions.assertEquals(expectedValue, account.getBalance());
    Assertions.assertEquals(result, initialBalance);
  }

  @Test
  void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
    double expectedValue = 300.00;
    double initialBalance = 800.00;
    Account account = AccountFactory.createAccount(initialBalance);

    account.withdraw(500.00);

    Assertions.assertEquals(expectedValue, account.getBalance());
  }

  @Test
  void withdrawShouldThrowExceptionWhenInsufficientBalance() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      double initialBalance = 500;
      Account account = AccountFactory.createAccount(initialBalance);
      account.withdraw(800.00);
    });
  }
}