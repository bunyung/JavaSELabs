 package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("중앙 도서관");

        addSampleBooks(library);

        System.out.println(library);
        System.out.println("\n=== 전체 도서 목록 ===");
        library.getAllBooks().forEach(System.out::println);

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    private static void testFindBook(Library library) {
        System.out.println("\n=== 도서 검색 테스트 ===");
        Book book = library.findBookByTitle("Clean Code");
        System.out.println(book != null ? book : "도서를 찾을 수 없습니다.");

        System.out.println("저자가 '남궁성'인 도서:");
        library.findBooksByAuthor("남궁성").forEach(System.out::println);
    }

    private static void testCheckOut(Library library) {
        System.out.println("\n=== 도서 대출 테스트 ===");
        boolean success = library.checkOutBook("978-0-13-235088-4");
        System.out.println(success ? "대출 성공" : "대출 실패");
    }

    private static void testReturn(Library library) {
        System.out.println("\n=== 도서 반납 테스트 ===");
        library.returnBook("978-0-13-235088-4");
        System.out.println("반납 완료");
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("\n=== 대출 가능 도서 목록 ===");
        library.getAvailableBooks().forEach(System.out::println);
    }
}
