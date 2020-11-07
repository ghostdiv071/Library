import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class LibraryFactory {

    @NotNull private final Library library;

    @Inject
    public LibraryFactory(int capacity, String fileName) {
        this.library = library(capacity, fileName);
    }

    public Library library(int capacity, String fileName) {
        return new Library(capacity, fileName);
    }
}
