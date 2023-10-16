import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

class AdminModule {
    public static void addBook(Library l) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = s.nextLine();
        System.out.print("Enter author: ");
        String author = s.nextLine();

        Book book = new Book(title, author);
        l.addBook(book);
        System.out.println("Book added successfully!");
    }
}

class UserModule {
    public static void displayBooks(Library l) {
        l.displayBooks();
    }
}

public class Main{
    public static void main(String[] args) {
        Library l = new Library();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Admin Module");
            System.out.println("2. User Module");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();  

            switch (choice) {
                case 1:
                    AdminModule.addBook(l);
                    break;
                case 2:
                    UserModule.displayBooks(l);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

