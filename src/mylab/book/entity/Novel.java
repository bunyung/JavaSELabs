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
    public String getTypeName() { return "소설"; }

    @Override
    public String toString() {
        return String.format("%s [소설] 저자:%s, 장르:%s, %d쪽, %,d원, 출판일:%s",
                title, author, genre, pages, price, publishDate.format(DF));
    }
}
