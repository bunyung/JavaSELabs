package workshop.account.entity;

public class Account {
	private String custId;
    private String acctId;
    private int balance;

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustId() {
        return custId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }
}
