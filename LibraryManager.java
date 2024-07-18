import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LibraryManager {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private HashMap<String, String> borrowedBooks; // <ISBN, Member ID>
    private HashMap<String, Integer> bookFines; // <ISBN, Fine Amount>

    public LibraryManager() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        borrowedBooks = new HashMap<>();
        bookFines = new HashMap<>();
    }

    // Book Management
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book removed: " + book);
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    public void updateBook(String isbn, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Book updated: " + book);
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void sortBooksByTitle() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });
        System.out.println("Books sorted by title.");
    }

    // Member Management
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member);
    }

    public void removeMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                members.remove(member);
                System.out.println("Member removed: " + member);
                return;
            }
        }
        System.out.println("Member with ID " + memberId + " not found.");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    // Borrow and Return Books
    public void borrowBook(String isbn, String memberId) {
        if (borrowedBooks.containsKey(isbn)) {
            System.out.println("Book is already borrowed.");
        } else {
            borrowedBooks.put(isbn, memberId);
            System.out.println("Book borrowed: " + isbn + " by Member: " + memberId);
        }
    }

    public void returnBook(String isbn) {
        if (borrowedBooks.containsKey(isbn)) {
            borrowedBooks.remove(isbn);
            System.out.println("Book returned: " + isbn);
        } else {
            System.out.println("Book with ISBN " + isbn + " is not borrowed.");
        }
    }

    // Fines Management
    public void calculateFine(String isbn, int daysLate) {
        int fineAmount = daysLate * 1; // Example: $1 per day late
        bookFines.put(isbn, fineAmount);
        System.out.println("Fine for book " + isbn + " is $" + fineAmount);
    }

    public void viewFines() {
        if (bookFines.isEmpty()) {
            System.out.println("No fines.");
        } else {
            for (String isbn : bookFines.keySet()) {
                System.out.println("Book ISBN: " + isbn + ", Fine: $" + bookFines.get(isbn));
            }
        }
    }
}
