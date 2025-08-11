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

    // 계좌번호 자동 생성: AC + 번호
    private String generateAccountNumber() {
        return "AC" + (accountSeq++);
    }

    public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accNum = generateAccountNumber();
        SavingsAccount sa = new SavingsAccount(accNum, ownerName, initialBalance, interestRate);
        accounts.add(sa);
        System.out.printf("Saving(저축) 계좌가 생성되었습니다: %s%n", sa);
        return sa;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawLimit) {
        String accNum = generateAccountNumber();
        CheckingAccount ca = new CheckingAccount(accNum, ownerName, initialBalance, withdrawLimit);
        accounts.add(ca);
        System.out.printf("체킹 계좌가 생성되었습니다: %s%n", ca);
        return ca;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n", amount, acc.getBalance());
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n", amount, acc.getBalance());
    }

    // 송금 (출금 계좌번호, 입금 계좌번호, 금액)
    public void transfer(String fromAccNum, String toAccNum, double amount) throws Exception {
        Account fromAcc = findAccount(fromAccNum);
        Account toAcc = findAccount(toAccNum);

        fromAcc.withdraw(amount);
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n", amount, fromAcc.getBalance());

        toAcc.deposit(amount);
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n", amount, toAcc.getBalance());

        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccNum, toAccNum);
    }


    public void applyInterestToAllSavings() {
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        }
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}
