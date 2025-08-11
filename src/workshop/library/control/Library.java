package workshop.library.control;

import workshop.library.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    // ���� �߰�
    public void addBook(Book book) {
        books.add(book);
    }

    // �������� �˻�
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // ���ڷ� �˻�
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // ISBN���� �˻�
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // ���� ����
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    // ���� �ݳ�
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    // ���� ������ ���� ���
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // ��� ���� ���
    public List<Book> getAllBooks() {
        return books;
    }

    // ��� ���� ��
    public int getTotalBooks() {
        return books.size();
    }

    // ���� ������ ���� ��
    public int getAvailableBookCount() {
        return getAvailableBooks().size();
    }
}
