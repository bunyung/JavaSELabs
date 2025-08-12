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
        // 샘플 데이터 (문제에 주어진 예시와 동일한 값 사용)
        books.add(new Magazine("마이크로소프트", "매월", 328, 9900, LocalDate.of(2007,10,1)));
        books.add(new Magazine("경영과컴퓨터", "매월", 316, 9000, LocalDate.of(2007,10,3)));
        books.add(new Novel("빠삐용", "베르나르베르베르", "현대소설", 396, 9800, LocalDate.of(2007,7,1)));
        books.add(new Novel("남한산성", "김훈", "대하소설", 383, 11000, LocalDate.of(2007,4,14)));
        books.add(new ReferenceBook("실용주의프로그래머", "소프트웨어공학", 496, 25000, LocalDate.of(2007,1,14)));
        books.add(new Novel("소년이온다", "한강", "장편소설", 216, 15000, LocalDate.of(2014,5,1)));
        books.add(new Novel("작별하지않는다", "한강", "장편소설", 332, 15120, LocalDate.of(2021,9,9)));
    }

    public List<Publication> getBooks() { return Collections.unmodifiableList(books); }

    public void printBooks() {
        System.out.println("==== 도서 정보 출력 ====\n");
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
        System.out.println("==== 가격 변경 ====\n");
        System.out.printf("%s 변경 전 가격: %,d원\n", p.getTitle(), p.getPrice());
        int old = p.getPrice();
        p.setPrice(newPrice);
        System.out.printf("%s 변경 후 가격: %,d원\n", p.getTitle(), p.getPrice());
        System.out.printf("차액: %,d원\n\n", Math.abs(newPrice - old));
        return true;
    }

    // 유틸: 전체 책 수
    public int totalCount() { return books.size(); }
}