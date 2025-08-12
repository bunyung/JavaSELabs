package mylab.book.entity;

import java.time.LocalDate;

public class ReferenceBook extends Publication {
    private String field;

    public ReferenceBook(String title, String field, int pages, int price, LocalDate publishDate) {
        super(title, pages, price, publishDate);
        this.field = field;
    }

    public String getField() { return field; }

    @Override
    public String getTypeName() { return "참고서"; }

    @Override
    public String toString() {
        return String.format("%s [참고서] 분야:%s, %d쪽, %,d원, 출판일:%s",
                title, field, pages, price, publishDate.format(DF));
    }
}