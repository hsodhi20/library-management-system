public class Book extends LibraryItem {
    public Book(String title, String author, String isbn) {
        super(title, author, isbn);
    }

    @Override
    public String toString() {
        return "Book - " + super.toString();
    }
}
