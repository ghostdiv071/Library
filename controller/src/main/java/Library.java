import com.google.inject.Inject;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Library {

    @NotNull
    @Getter
    private final Book[] books;

    @NotNull
    @Getter
    private final FileBookFactory fileBookFactory;

    @Getter
    private final int capacity;

    private final String fileName;

    @Inject
    public Library(int capacity, String fileName) {
        this.capacity = capacity;
        books = new Book[capacity];
        this.fileName = fileName;
        fileBookFactory = new FileBookFactory(this.fileName);

        try {
            ArrayList<Book> bookArrayList = new ArrayList<>(fileBookFactory.books());
            for (int i = 0; i < bookArrayList.size(); i++) {
                books[i] = bookArrayList.get(i);
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Book getBook(int index) {
        System.out.println(index + ": " + books[index].toString());
        return books[index];
    }

    public void addBook(Book book) {
        try {
            int count = 0;
            for (Book item : books) {
                if (item != null){
                    count++;
                }
            }
            books[count] = book;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
