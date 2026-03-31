package service;
import java.util.*;
import model.*;
import util.FileUtil;

public class LibraryService {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private final String BOOK_FILE = "books.ser";
    private final String MEMBER_FILE = "members.ser";
    private Scanner sc = new Scanner(System.in);

    public LibraryService() {
        books = FileUtil.loadData(BOOK_FILE);
        members = FileUtil.loadData(MEMBER_FILE);
    }

    public void addBook() {
        System.out.print("Enter Book ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        if (books.containsKey(id)) {
            System.out.println("Book ID already exists!");
            return;
        }
        Book book = new Book(id, title, author);
        books.put(id, book);
        saveAll();
        System.out.println("✅ Book added successfully!");
    }

    public void registerMember() {
        System.out.print("Enter Member ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        if (members.containsKey(id)) {
            System.out.println("Member already registered!");
            return;
        }
        Member member = new Member(id, name);
        members.put(id, member);
        saveAll();
        System.out.println("✅ Member registered successfully!");
    }

    public void borrowBook() {
        System.out.print("Enter Member ID: ");
        String mId = sc.nextLine();
        Member member = members.get(mId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.print("Enter Book ID: ");
        String bId = sc.nextLine();
        Book book = books.get(bId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed!");
            return;
        }

        book.setAvailable(false);
        member.borrowBook(bId);
        saveAll();
        System.out.println("📚 Book borrowed successfully!");
    }

    public void returnBook() {
        System.out.print("Enter Member ID: ");
        String mId = sc.nextLine();
        Member member = members.get(mId);
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.print("Enter Book ID: ");
        String bId = sc.nextLine();
        Book book = books.get(bId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!member.getBorrowedBooks().contains(bId)) {
            System.out.println("This member didn’t borrow this book!");
            return;
        }

        book.setAvailable(true);
        member.returnBook(bId);
        saveAll();
        System.out.println("✅ Book returned successfully!");
    }

    public void searchBook() {
        System.out.print("Enter title/author keyword: ");
        String keyword = sc.nextLine().toLowerCase();
        books.values().stream()
             .filter(b -> b.getTitle().toLowerCase().contains(keyword) || 
                          b.getAuthor().toLowerCase().contains(keyword))
             .forEach(System.out::println);
    }

    public void listAllBooks() {
        System.out.println("\n--- All Books ---");
        System.out.printf("%-10s %-25s %-20s %-10s\n", "ID", "Title", "Author", "Status");
        System.out.println("---------------------------------------------------------------");
        books.values().forEach(System.out::println);
    }

    private void saveAll() {
        FileUtil.saveData(books, BOOK_FILE);
        FileUtil.saveData(members, MEMBER_FILE);
    }
}