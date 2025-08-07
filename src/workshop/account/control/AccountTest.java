package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {
	public static void main(String[] args) {
        // Account ��ü ����
        Account acc = new Account();

        // �� �Ҵ�
        acc.setCustId("A1100");
        acc.setAcctId("221-22-3477");
        acc.setBalance(100000);

        // ����ȣ �� ���¹�ȣ ���
        System.out.println("����ȣ: " + acc.getCustId());
        System.out.println("���¹�ȣ: " + acc.getAcctId());

        // �ʱ� �ܾ� ���
        System.out.println("���� �ܾ�: " + acc.getBalance() + "��");

        // �Ա�
        acc.deposit(10000);
        System.out.println("�Ա� �� �ܾ�: " + acc.getBalance() + "��");

        // ���
        acc.withdraw(20000);
        System.out.println("��� �� �ܾ�: " + acc.getBalance() + "��");

		// TODO Auto-generated method stub

	}

}
