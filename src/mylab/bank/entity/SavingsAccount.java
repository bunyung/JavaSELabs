package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;  // �� ������ %

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    @Override
    public void withdraw(double amount) throws Exception {
        if(amount <= 0) throw new IllegalArgumentException("��ݾ��� ������� �մϴ�.");
        if(amount > balance) throw new mylab.bank.exception.InsufficientBalanceException("�ܾ��� �����մϴ�.");
        balance -= amount;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��%n", interest, balance);
    }

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%",
                accountNumber, ownerName, balance, interestRate);
    }
}
