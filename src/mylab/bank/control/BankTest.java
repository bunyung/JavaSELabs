package mylab.bank.control;

import mylab.bank.control.Bank;
import mylab.bank.exception.*;
import mylab.bank.entity.*;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // ���� ����
        System.out.println("\n=== ���� ���� ===");
        bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
        bank.createCheckingAccount("��ö��", 20000, 5000);
        bank.createSavingsAccount("�̿���", 30000, 2.0);

        System.out.println();  // �� �� ����
        
        bank.printAllAccounts();

        try {
            // �Ա�/��� �׽�Ʈ
        	System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1000", 3000);

            // ���� ���� �׽�Ʈ
            System.out.println("\n=== ���� ���� �׽�Ʈ ===");
            bank.applyInterestToAllSavings();

            // ���� ��ü �׽�Ʈ
            System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
            bank.transfer("AC1002", "AC1001", 5000);

            System.out.println();  // �� �� ����
            
            bank.printAllAccounts();

            // ���� �׽�Ʈ
            bank.withdraw("AC1001", 6000); // ��� �ѵ� �ʰ�
        } catch (WithdrawLimitExceededException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.withdraw("AC9999", 1000); // ���� ����
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
