package mylab.book.control;

import mylab.book.entity.*;
import java.time.LocalDate;
import java.util.*;

public class ManageBook {
    private List<Publication> books;

    public ManageBook() {
        books = new ArrayList<>();
    }

    public void initSampleData() {
        // ���� ������ (������ �־��� ���ÿ� ������ �� ���)
        books.add(new Magazine("����ũ�μ���Ʈ", "�ſ�", 328, 9900, LocalDate.of(2007,10,1)));
        books.add(new Magazine("�濵����ǻ��", "�ſ�", 316, 9000, LocalDate.of(2007,10,3)));
        books.add(new Novel("���߿�", "����������������", "����Ҽ�", 396, 9800, LocalDate.of(2007,7,1)));
        books.add(new Novel("���ѻ꼺", "����", "���ϼҼ�", 383, 11000, LocalDate.of(2007,4,14)));
        books.add(new ReferenceBook("�ǿ��������α׷���", "����Ʈ�������", 496, 25000, LocalDate.of(2007,1,14)));
        books.add(new Novel("�ҳ��̿´�", "�Ѱ�", "����Ҽ�", 216, 15000, LocalDate.of(2014,5,1)));
        books.add(new Novel("�ۺ������ʴ´�", "�Ѱ�", "����Ҽ�", 332, 15120, LocalDate.of(2021,9,9)));
    }

    public List<Publication> getBooks() { return Collections.unmodifiableList(books); }

    public void printBooks() {
        System.out.println("==== ���� ���� ��� ====\n");
        int idx = 1;
        for (Publication p : books) {
            System.out.printf("%d. %s\n", idx++, p.toString());
        }
        System.out.println();
    }

    public Publication findBookByTitle(String title) {
        for (Publication p : books) {
            if (p.getTitle().equals(title)) return p;
        }
        return null;
    }

    public boolean changePrice(String title, int newPrice) {
        Publication p = findBookByTitle(title);
        if (p == null) return false;
        System.out.println("==== ���� ���� ====\n");
        System.out.printf("%s ���� �� ����: %,d��\n", p.getTitle(), p.getPrice());
        int old = p.getPrice();
        p.setPrice(newPrice);
        System.out.printf("%s ���� �� ����: %,d��\n", p.getTitle(), p.getPrice());
        System.out.printf("����: %,d��\n\n", Math.abs(newPrice - old));
        return true;
    }

    // ��ƿ: ��ü å ��
    public int totalCount() { return books.size(); }
}