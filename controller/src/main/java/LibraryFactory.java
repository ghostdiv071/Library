import lombok.Getter;

@Getter
public class LibraryFactory {

    Library library(int capacity, String fileName) {
        return new Library(capacity, fileName);
    }

}
