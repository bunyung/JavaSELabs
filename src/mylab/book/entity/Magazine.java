package mylab.book.entity;

import java.time.LocalDate;

public class Magazine extends Publication {
    private String publishCycle;

    public Magazine(String title, String publishCycle, int pages, int price, LocalDate publishDate) {
        super(title, pages, price, publishDate);
        this.publishCycle = publishCycle;
    }

    public String getPublishCycle() { return publishCycle; }

    @Override
    public String getTypeName() { return "����"; }

    @Override
    public String toString() {
        return String.format("%s [����] �����ֱ�:%s, %d��, %,d��, ������:%s",
                title, publishCycle, pages, price, publishDate.format(DF));
    }
}
