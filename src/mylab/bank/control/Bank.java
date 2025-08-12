package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int accountSeq;

    public Bank() {
        accounts = new ArrayList<>();
        accountSeq = 1000;
    }

    // ���¹�ȣ �ڵ� ����: AC + ��ȣ
    private String generateAccountNumber() {
        return "AC" + (accountSeq++);
    }

    public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accNum = generateAccountNumber();
        SavingsAccount sa = new SavingsAccount(accNum, ownerName, initialBalance, interestRate);
        accounts.add(sa);
        System.out.printf("Saving(����) ���°� �����Ǿ����ϴ�: %s%n", sa);
        return sa;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawLimit) {
        String accNum = generateAccountNumber();
        CheckingAccount ca = new CheckingAccount(accNum, ownerName, initialBalance, withdrawLimit);
        accounts.add(ca);
        System.out.printf("üŷ ���°� �����Ǿ����ϴ�: %s%n", ca);
        return ca;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."));
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, acc.getBalance());
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, acc.getBalance());
    }

    // �۱� (��� ���¹�ȣ, �Ա� ���¹�ȣ, �ݾ�)
    public void transfer(String fromAccNum, String toAccNum, double amount) throws Exception {
        Account fromAcc = findAccount(fromAccNum);
        Account toAcc = findAccount(toAccNum);

        fromAcc.withdraw(amount);
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, fromAcc.getBalance());

        toAcc.deposit(amount);
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, toAcc.getBalance());

        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccNum, toAccNum);
    }


    public void applyInterestToAllSavings() {
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        }
    }

    public void printAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}
