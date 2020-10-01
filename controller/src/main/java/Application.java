import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static List<Author> authors = new LinkedList<>();

    private static void setAuthors() {
        authors.add(new Author(1, "Stephen King"));
        authors.add(new Author(2, "Howard Lovecraft"));
        authors.add(new Author(3, "Irvine Welsh"));
    }

    public static void main(String[] args) {
        setAuthors();
        appExecution();
    }

    private static void appExecution() {
        Scanner scanner = new Scanner(System.in);

        LibFactory factory = new LibFactory();
        Library library = factory.createLibrary();

        System.out.println("Authors");
        for (Author author : authors) {
            System.out.printf("%d %s%n'", author.getId(), author.getName());
        }
        System.out.print("Choose author: ");
        int authorId = scanner.nextInt();

        for (Book book : library.getBooks()) {
            if (book.getAuthorId() == authorId) {
                System.out.println(new Gson().toJson(book));
            }
        }
    }

}
