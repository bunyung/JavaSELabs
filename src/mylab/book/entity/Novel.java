package mylab.book.entity;

import java.time.LocalDate;

public class Novel extends Publication {
    private String author;
    private String genre;

    public Novel(String title, String author, String genre, int pages, int price, LocalDate publishDate) {
        super(title, pages, price, publishDate);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() { return author; }
    public String getGenre() { return genre; }

    @Override
    public String getTypeName() { return "�Ҽ�"; }

    @Override
    public String toString() {
        return String.format("%s [�Ҽ�] ����:%s, �帣:%s, %d��, %,d��, ������:%s",
                title, author, genre, pages, price, publishDate.format(DF));
    }
}
