import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class AllMoviesPageTest {

    String genreValue = "Драма";
    AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();

    @Test
    public void genreFilterTest() {
        allMoviesPageSteps
                .openAllMovies()
                .useGenreFilter(genreValue);
        assertThat(allMoviesPageSteps.genreCheck(genreValue)).isTrue();
    }
}
