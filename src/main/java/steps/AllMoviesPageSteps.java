package steps;

import pages.AllMoviesPage;
import pages.LoginPage;

public class AllMoviesPageSteps {
    AllMoviesPage allMoviesPage = new AllMoviesPage();

    public AllMoviesPageSteps openAllMovies() {
        allMoviesPage.setAllMoviesLink();
        return this;
    }

    public AllMoviesPageSteps useGenreFilter(String genre) {
        allMoviesPage
                .genreList()
                .setGenre(genre);
        return this;
    }

    public boolean genreCheck(String genre) {
        return allMoviesPage.check(genre);
    }

}
