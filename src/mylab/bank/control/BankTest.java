package mylab.bank.control;

import mylab.bank.control.Bank;
import mylab.bank.exception.*;
import mylab.bank.entity.*;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 계좌 생성
        System.out.println("\n=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000, 3.0);
        bank.createCheckingAccount("김철수", 20000, 5000);
        bank.createSavingsAccount("이영희", 30000, 2.0);

        System.out.println();  // 한 줄 띄우기
        
        bank.printAllAccounts();

        try {
            // 입금/출금 테스트
        	System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1000", 3000);

            // 이자 적용 테스트
            System.out.println("\n=== 이자 적용 테스트 ===");
            bank.applyInterestToAllSavings();

            // 계좌 이체 테스트
            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer("AC1002", "AC1001", 5000);

            System.out.println();  // 한 줄 띄우기
            
            bank.printAllAccounts();

            // 예외 테스트
            bank.withdraw("AC1001", 6000); // 출금 한도 초과
        } catch (WithdrawLimitExceededException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC9999", 1000); // 없는 계좌
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
