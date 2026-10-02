import java.util.*;

class Book {
    String id;
    String title;
    boolean available;
    Member issuedTo;

    Book(String id, String title) {
        this.id = id;
        this.title = title;
        available = true;
    }

    boolean isAvailable() {
        return available;
    }

    void issueTo(Member member) {
        available = false;
        issuedTo = member;
    }

    void returnBook() {
        available = true;
        issuedTo = null;
    }

    double calculateLateFee(int days) {
        if (days <= 7) {
            return 0;
        }
        return (days - 7) * 5;
    }
}

abstract class Member {
    String id;
    String name;
    ArrayList<Book> borrowedBooks;

    Member(String id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    abstract int getBorrowingLimit();

    boolean canBorrow() {
        return borrowedBooks.size() < getBorrowingLimit();
    }

    void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.issueTo(this);
    }

    void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }
}

class StudentMember extends Member {
    StudentMember(String id, String name) {
        super(id, name);
    }

    int getBorrowingLimit() {
        return 2;
    }
}

class FacultyMember extends Member {
    FacultyMember(String id, String name) {
        super(id, name);
    }

    int getBorrowingLimit() {
        return 5;
    }
}

class GuestMember extends Member {
    GuestMember(String id, String name) {
        super(id, name);
    }

    int getBorrowingLimit() {
        return 1;
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    Book findBook(String id) {
        for (Book book : books) {
            if (book.id.equals(id)) {
                return book;
            }
        }
        return null;
    }

    void issueBook(String bookId, Member member) {
        Book book = findBook(bookId);

        if (book != null && book.isAvailable() && member.canBorrow()) {
            member.borrowBook(book);
            System.out.println("Book issued successfully");
        } else {
            System.out.println("Book cannot be issued");
        }
    }

    void returnBook(String bookId, Member member) {
        Book book = findBook(bookId);

        if (book != null && !book.isAvailable() && book.issuedTo == member) {
            member.returnBook(book);
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book cannot be returned");
        }
    }
}

class Librarian {
    String name;

    Librarian(String name) {
        this.name = name;
    }
}

public class Soln9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String title = sc.next();
            library.addBook(new Book(id, title));
        }
        String type = sc.next();
        String memberId = sc.next();
        String memberName = sc.nextLine().trim();
        Member member;
        if (type.equals("STUDENT")) {
            member = new StudentMember(memberId, memberName);
        } else if (type.equals("FACULTY")) {
            member = new FacultyMember(memberId, memberName);
        } else {
            member = new GuestMember(memberId, memberName);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String operation = sc.next();
            String bookId = sc.next();

            if (operation.equals("BORROW")) {
                library.issueBook(bookId, member);
            } else if (operation.equals("RETURN")) {
                library.returnBook(bookId, member);
            }
        }
    }
}