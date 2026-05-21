package library;


public class Library {

    private String name;
    private Book[] books;
    private int bookCount;

    public Library(String name, int capacity) {
        this.name = name;
        this.books = new Book[capacity];
        this.bookCount = 0;
    }


    public void addBook(Book book) {
        if (bookCount >= books.length) {
            System.out.println("Library is fulls");
            return;
        }
        books[bookCount] = book;
        bookCount++;
        System.out.println("Added: " + book.getTitle());
    }


    public Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }


    public void borrowBook(Member member, String title) {
        Book book = findBook(title);

        if (book == null) {
            System.out.println("Book not found: " + title);
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already borrowed: " + title);
            return;
        }

        book.setAvailable(false);
        System.out.println(member.getName() + " borrowed.");
    }

    public void returnBook(Member member, String title) {
        Book book = findBook(title);

        if (book == null) {
            System.out.println("Book not found: " + title);
            return;
        }
        if (book.isAvailable()) {
            System.out.println("This book was not borrowed: " + title);
            return;
        }

        book.setAvailable(true);
        System.out.println(member.getName() + " returned.");
    }


    public void printAllBooks() {
        System.out.println("\nAll books in " + name + ":");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("  " + books[i]);
        }
    }


    public void printAvailableBooks() {
        System.out.println("\nAvailable books in " + name + ":");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println("  " + books[i]);
            }
        }
    }
}
