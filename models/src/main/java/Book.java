import lombok.Data;
import lombok.NonNull;

@Data
public class Book {

    private final int isbn;

    @NonNull
    private String name;

    @NonNull
    private String genre;

    @NonNull
    private String publisher;

    private final int authorId;

}