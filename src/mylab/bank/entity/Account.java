package mylab.bank.entity;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    // ����� ���� Ŭ�������� ����ó�� �����ؼ� ����
    public abstract void withdraw(double amount) throws Exception;

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��", accountNumber, ownerName, balance);
    }
}

