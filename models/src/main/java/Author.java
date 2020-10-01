import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.List;

@Data
@RequiredArgsConstructor
public final class Author {

    @NonNull
    private final int id;

    @NonNull
    private String name;

    @Singular
    private List<Book> books;
}
