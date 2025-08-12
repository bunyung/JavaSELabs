package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;  // 연 이자율 %

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    @Override
    public void withdraw(double amount) throws Exception {
        if(amount <= 0) throw new IllegalArgumentException("출금액은 양수여야 합니다.");
        if(amount > balance) throw new mylab.bank.exception.InsufficientBalanceException("잔액이 부족합니다.");
        balance -= amount;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, balance);
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%",
                accountNumber, ownerName, balance, interestRate);
    }
}
