package mylab.book.control;

import mylab.book.entity.*;

public class MainTest {
    public static void main(String[] args) {
        ManageBook manager = new ManageBook();
        manager.initSampleData();

        // ���� ���
        manager.printBooks();

        // ���� ���� (���ð� �����ϰ� "�ۺ������ʴ´�"�� ������ 12096���� ����)
        manager.changePrice("�ۺ������ʴ´�", 12096);

        // ��� �м�
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer(manager.getBooks());
        analyzer.printStatistics();

        // ��ٱ��� �׽�Ʈ
        ShoppingCart cart = new ShoppingCart();
        cart.addBook(manager.findBookByTitle("����ũ�μ���Ʈ"));
        cart.addBook(manager.findBookByTitle("�濵����ǻ��"));
        cart.addBook(manager.findBookByTitle("���߿�"));
        cart.addBook(manager.findBookByTitle("���ѻ꼺"));
        cart.addBook(manager.findBookByTitle("�ǿ��������α׷���"));

        cart.printCart();
        cart.removeBook("���߿�");
        cart.printCart();
    }
}