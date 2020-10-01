import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Library {

    @Getter
    @Setter
    private List<Book> books;

}
