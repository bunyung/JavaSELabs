package workshop.library.test;

import workshop.library.entity.Book;
import workshop.library.control.Library;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // ���� �߰�
        library.addBook(new Book("�ڹ��� ����", "���ü�", "1111", 2016));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "2222", 2018));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "3333", 2009));

        // ��ü ���� ��� ���
        System.out.println("=== ��� ���� ��� ===");
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }

        // ���� �˻�
        System.out.println("\n=== ���� �˻�: '�ڹ��� ����' ===");
        System.out.println(library.findByTitle("�ڹ��� ����"));

        // ���� �˻�
        System.out.println("\n=== ���� �˻�: 'Joshua Bloch' ===");
        for (Book b : library.findByAuthor("Joshua Bloch")) {
            System.out.println(b);
        }

        // ISBN �˻�
        System.out.println("\n=== ISBN �˻�: '3333' ===");
        System.out.println(library.findByISBN("3333"));

        // ���� ����
        System.out.println("\n=== '1111' ���� ���� ===");
        if (library.checkOutBook("1111")) {
            System.out.println("���� ����!");
        } else {
            System.out.println("���� ����!");
        }

        // ���� ������ ���� ���
        System.out.println("\n=== ���� ������ ���� ��� ===");
        for (Book b : library.getAvailableBooks()) {
            System.out.println(b);
        }

        // ���� �ݳ�
        System.out.println("\n=== '1111' ���� �ݳ� ===");
        if (library.returnBook("1111")) {
            System.out.println("�ݳ� ����!");
        } else {
            System.out.println("�ݳ� ����!");
        }

        // ��ü ���
        System.out.println("\n�� ���� ��: " + library.getTotalBooks());
        System.out.println("���� ������ ���� ��: " + library.getAvailableBookCount());
    }
}
