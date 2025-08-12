package mylab.book.control;

import java.util.ArrayList;
import java.util.List;
import mylab.book.entity.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public void addBook(Publication p) {
        items.add(p);
        System.out.println(p.getTitle() + "이(가) 장바구니에 추가되었습니다.");
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
            System.out.println(title + "이(가) 장바구니에서 제거되었습니다.");
        }
    }

    public void printCart() {
        System.out.println("====== 장바구니 내용 ======");
        int index = 1;
        int total = 0;
        for (Publication p : items) {
            System.out.printf("%d. %s - %,d원%n", index++, p.getTitle(), p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("총 가격: %,d원%n", total);
        System.out.printf("할인 적용 가격: %,d원%n", calculateDiscountedTotal());
    }

    // 타입별 할인 계산
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
        System.out.println("====== 장바구니 통계 ======");
        System.out.printf("잡지: %d권%n", magCount);
        System.out.printf("소설: %d권%n", novelCount);
        System.out.printf("참고서: %d권%n", refCount);
        System.out.printf("총 출판물: %d권%n", items.size());
    }
}
