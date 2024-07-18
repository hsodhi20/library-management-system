import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private LibraryManager libraryManager;

    public UserInterface() {
        scanner = new Scanner(System.in);
        libraryManager = new LibraryManager();
    }

    public void start() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Books");
            System.out.println("4. Update Book");
            System.out.println("5. Add Member");
            System.out.println("6. Remove Member");
            System.out.println("7. View Members");
            System.out.println("8. Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("10. Calculate Fine");
            System.out.println("11. View Fines");
            System.out.println("12. Sort Books by Title");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    libraryManager.viewBooks();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    addMember();
                    break;
                case 6:
                    removeMember();
                    break;
                case 7:
                    libraryManager.viewMembers();
                    break;
                case 8:
                    borrowBook();
                    break;
                case 9:
                    returnBook();
                    break;
                case 10:
                    calculateFine();
                    break;
                case 11:
                    libraryManager.viewFines();
                    break;
                case 12:
                    libraryManager.sortBooksByTitle();
                    break;
                case 13:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        libraryManager.addBook(new Book(title, author, isbn));
    }

    private void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        libraryManager.removeBook(isbn);
    }

    private void updateBook() {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new author: ");
        String newAuthor = scanner.nextLine();
        libraryManager.updateBook(isbn, newTitle, newAuthor);
    }

    private void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        libraryManager.addMember(new Member(name, memberId));
    }

    private void removeMember() {
        System.out.print("Enter member ID to remove: ");
        String memberId = scanner.nextLine();
        libraryManager.removeMember(memberId);
    }

    private void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        libraryManager.borrowBook(isbn, memberId);
    }

    private void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();
        libraryManager.returnBook(isbn);
    }

    private void calculateFine() {
        System.out.print("Enter ISBN of the book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter number of days late: ");
        int daysLate = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        libraryManager.calculateFine(isbn, daysLate);
    }
}
