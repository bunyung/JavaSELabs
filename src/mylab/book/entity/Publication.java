package mylab.book.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Publication {
    protected String title;
    protected int pages;
    protected int price; // �� ����
    protected LocalDate publishDate;
    protected static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Publication(String title, int pages, int price, LocalDate publishDate) {
        this.title = title;
        this.pages = pages;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String getTitle() { return title; }
    public int getPages() { return pages; }
    public int getPrice() { return price; }
    public LocalDate getPublishDate() { return publishDate; }

    public void setPrice(int price) { this.price = price; }

    public String getTypeName() { return "���ǹ�"; }

    @Override
    public String toString() {
        return String.format("%s, %d��, %,d��, ������:%s",
                title, pages, price, publishDate.format(DF));
    }
}
