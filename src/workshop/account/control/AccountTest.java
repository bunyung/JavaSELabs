package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
        // Account 객체 생성
        Account acc = new Account();

        // 값 할당
        acc.setCustId("A1100");
        acc.setAcctId("221-22-3477");
        acc.setBalance(100000);

        // 고객번호 및 계좌번호 출력
        System.out.println("고객번호: " + acc.getCustId());
        System.out.println("계좌번호: " + acc.getAcctId());

        // 초기 잔액 출력
        System.out.println("현재 잔액: " + acc.getBalance() + "원");

        // 입금
        acc.deposit(10000);
        System.out.println("입금 후 잔액: " + acc.getBalance() + "원");

        // 출금
        acc.withdraw(20000);
        System.out.println("출금 후 잔액: " + acc.getBalance() + "원");

		// TODO Auto-generated method stub

	}

}
