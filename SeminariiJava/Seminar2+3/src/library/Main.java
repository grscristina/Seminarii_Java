package library;

public class Main {
    public static void main(String[] args) {


        Library library = new Library(" Library", 10);


        library.addBook(new Book("Java", "ASE"));
        library.addBook(new Book("Harry Potter2", "Rowling"));
        library.addBook(new Book("Harry Potter", "Rowling"));


        Member ion = new Member("Ion", 1);
        Member maria = new Member("Maria", 2);

        library.printAllBooks();


        library.borrowBook(ion, "Java");
        library.borrowBook(maria, "Harry Potter");


        library.borrowBook(maria, "Java");


        library.borrowBook(ion, "C++");

        library.printAvailableBooks();

        library.returnBook(ion, "Java");

        library.printAvailableBooks();
    }
}
