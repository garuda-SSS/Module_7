package steps;

import pages.AllMoviesPage;

public class AllMoviesPageSteps {
    private AllMoviesPage allMoviesPage = new AllMoviesPage();

    public AllMoviesPageSteps openAllMovies() {
        allMoviesPage.allMoviesLinkClick();
        return this;
    }

    public AllMoviesPageSteps useGenreFilter(String genre) {
        allMoviesPage
                .openGenreDropdown()
                .setGenre(genre);
        return this;
    }

    public boolean genreCheck(String genre) {
        return allMoviesPage.checkGenre(genre);
    }

}
