package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    private String memberId;
    private String name;
    private List<String> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<String> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(String bookId) {
        borrowedBooks.add(bookId);
    }

    public void returnBook(String bookId) {
        borrowedBooks.remove(bookId);
    }

    @Override
    public String toString() {
        return memberId + " - " + name + " | Borrowed: " + borrowedBooks;
    }
}