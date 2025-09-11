import io.qameta.allure.Allure;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class AllMoviesPageTest {

    private final String genreValue = "Драма";
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("regress")
    })
    @DisplayName("Тест фильтра по жанрам")  // Будет отображаться вместо имени метода
    public void genreFilterTest() {
        allMoviesPageSteps
                .openAllMovies()
                .setGenreFilter(genreValue);
        Allure.step("Проверяем, что все фильмы в выдаче были с выбранным жанром", () -> {
            assertThat(allMoviesPageSteps.verifyGenreOfMovies(genreValue)).isTrue();
        });

    }
}
