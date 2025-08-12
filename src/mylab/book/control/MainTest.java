package mylab.book.control;

import mylab.book.entity.*;

public class MainTest {
    public static void main(String[] args) {
        ManageBook manager = new ManageBook();
        manager.initSampleData();

        // 도서 출력
        manager.printBooks();

        // 가격 변경 (샘플과 동일하게 "작별하지않는다"의 가격을 12096으로 변경)
        manager.changePrice("작별하지않는다", 12096);

        // 통계 분석
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer(manager.getBooks());
        analyzer.printStatistics();

        // 장바구니 테스트
        ShoppingCart cart = new ShoppingCart();
        cart.addBook(manager.findBookByTitle("마이크로소프트"));
        cart.addBook(manager.findBookByTitle("경영과컴퓨터"));
        cart.addBook(manager.findBookByTitle("빠삐용"));
        cart.addBook(manager.findBookByTitle("남한산성"));
        cart.addBook(manager.findBookByTitle("실용주의프로그래머"));

        cart.printCart();
        cart.removeBook("빠삐용");
        cart.printCart();
    }
}