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
        if(amount <= 0) throw new IllegalArgumentException("��ݾ��� ������� �մϴ�.");
        if(amount > withdrawLimit)
            throw new WithdrawLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawLimit + "��");
        if(amount > balance)
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�.");
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��",
                accountNumber, ownerName, balance, withdrawLimit);
    }
}
