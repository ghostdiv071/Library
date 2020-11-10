import lombok.Data;
import lombok.NonNull;

@Data
public class Book {

    @NonNull
    private String name;

    @NonNull
    private Author author;

}