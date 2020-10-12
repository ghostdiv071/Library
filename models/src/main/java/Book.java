import lombok.Data;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@Data
public class Book {

    @NonNull
    private String name;

    @NotNull
    private String authorName;

}