package workshop.library.test;

import workshop.library.entity.Book;
import workshop.library.control.Library;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // 도서 추가
        library.addBook(new Book("자바의 정석", "남궁성", "1111", 2016));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "2222", 2018));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "3333", 2009));

        // 전체 도서 목록 출력
        System.out.println("=== 모든 도서 목록 ===");
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }

        // 제목 검색
        System.out.println("\n=== 제목 검색: '자바의 정석' ===");
        System.out.println(library.findByTitle("자바의 정석"));

        // 저자 검색
        System.out.println("\n=== 저자 검색: 'Joshua Bloch' ===");
        for (Book b : library.findByAuthor("Joshua Bloch")) {
            System.out.println(b);
        }

        // ISBN 검색
        System.out.println("\n=== ISBN 검색: '3333' ===");
        System.out.println(library.findByISBN("3333"));

        // 도서 대출
        System.out.println("\n=== '1111' 도서 대출 ===");
        if (library.checkOutBook("1111")) {
            System.out.println("대출 성공!");
        } else {
            System.out.println("대출 실패!");
        }

        // 대출 가능한 도서 목록
        System.out.println("\n=== 대출 가능한 도서 목록 ===");
        for (Book b : library.getAvailableBooks()) {
            System.out.println(b);
        }

        // 도서 반납
        System.out.println("\n=== '1111' 도서 반납 ===");
        if (library.returnBook("1111")) {
            System.out.println("반납 성공!");
        } else {
            System.out.println("반납 실패!");
        }

        // 전체 통계
        System.out.println("\n총 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능한 도서 수: " + library.getAvailableBookCount());
    }
}
