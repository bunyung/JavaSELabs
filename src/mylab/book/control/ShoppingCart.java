package mylab.book.control;

import java.util.ArrayList;
import java.util.List;
import mylab.book.entity.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public void addBook(Publication p) {
        items.add(p);
        System.out.println(p.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    public void removeBook(String title) {
        Publication toRemove = null;
        for (Publication p : items) {
            if (p.getTitle().equals(title)) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
            System.out.println(title + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
        }
    }

    public void printCart() {
        System.out.println("====== ��ٱ��� ���� ======");
        int index = 1;
        int total = 0;
        for (Publication p : items) {
            System.out.printf("%d. %s - %,d��%n", index++, p.getTitle(), p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("�� ����: %,d��%n", total);
        System.out.printf("���� ���� ����: %,d��%n", calculateDiscountedTotal());
    }

    // Ÿ�Ժ� ���� ���
    private int calculateDiscountedTotal() {
        int discountedTotal = 0;
        for (Publication p : items) {
            double discountRate = 0.0;

            if (p instanceof Magazine) {
                discountRate = 0.10; // 10%
            } else if (p instanceof Novel) {
                discountRate = 0.15; // 15%
            } else if (p instanceof ReferenceBook) {
                discountRate = 0.20; // 20%
            }

            int discountedPrice = (int) Math.round(p.getPrice() * (1 - discountRate));
            discountedTotal += discountedPrice;
        }
        return discountedTotal;
    }

    public void printStatistics() {
        int magCount = 0, novelCount = 0, refCount = 0;
        for (Publication p : items) {
            if (p instanceof Magazine) magCount++;
            else if (p instanceof Novel) novelCount++;
            else if (p instanceof ReferenceBook) refCount++;
        }
        System.out.println("====== ��ٱ��� ��� ======");
        System.out.printf("����: %d��%n", magCount);
        System.out.printf("�Ҽ�: %d��%n", novelCount);
        System.out.printf("����: %d��%n", refCount);
        System.out.printf("�� ���ǹ�: %d��%n", items.size());
    }
}
