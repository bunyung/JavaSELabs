package mylab.bank.entity;

import mylab.bank.exception.WithdrawLimitExceededException;
import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {
    private double withdrawLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawLimit = withdrawLimit;
    }

    public double getWithdrawLimit() { return withdrawLimit; }

    @Override
    public void withdraw(double amount) throws Exception {
        if(amount <= 0) throw new IllegalArgumentException("출금액은 양수여야 합니다.");
        if(amount > withdrawLimit)
            throw new WithdrawLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawLimit + "원");
        if(amount > balance)
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원",
                accountNumber, ownerName, balance, withdrawLimit);
    }
}
