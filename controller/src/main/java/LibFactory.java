import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LibFactory {

    public Library createLibrary() {
        Library library = new Library();
        String booksInfoFileName = "./controller/src/main/java/books";
        library.setBooks(readAndValidateData(booksInfoFileName));
        return library;
    }

    private List<Book> readAndValidateData(String filePath) {
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = in.readLine()) != null) {
                stringList.add(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Book> bookList = new LinkedList<>();
        for (String info : stringList) {
            Book book = validateInfo(info);
            bookList.add(book);
        }
        return bookList;
    }

    private Book validateInfo(String infoString) {
        String[] info = infoString.split(", ");
        int isbn = Integer.parseInt(info[0]);
        String name = info[1];
        String genre = info[2];
        String publisher = info[3];
        int authorId = Integer.parseInt(info[4]);

        return new Book(isbn, name, genre, publisher, authorId);
    }
}
