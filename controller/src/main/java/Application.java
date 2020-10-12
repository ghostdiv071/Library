import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;

public class Application {

    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new TestModule());
        injector.getInstance(LibraryFactory.class).createLibrary(2, "controller/src/main/java/books");
    }
}
