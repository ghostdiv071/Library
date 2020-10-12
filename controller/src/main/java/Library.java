import com.google.inject.Inject;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

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
            Book[] bookArray = (Book[]) fileBookFactory.books().toArray();
            System.arraycopy(bookArray, 0, books, 0, bookArray.length);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String getBook(int index) {
        return index + " " + books[index].toString();
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

    public void printToConsole() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
