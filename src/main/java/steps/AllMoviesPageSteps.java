package steps;

import io.qameta.allure.Step;
import pages.AllMoviesPage;

public class AllMoviesPageSteps {
    private final AllMoviesPage allMoviesPage = new AllMoviesPage();

    @Step("Переходим к списку фильмов")
    public AllMoviesPageSteps openAllMovies() {
        allMoviesPage.allMoviesLinkClick();
        return this;
    }

    @Step("Устанавливаем фильтр по жанру")
    public void setGenreFilter(String genre) {
        allMoviesPage
                .openGenreDropdown()
                .genreClick(genre);
    }

    @Step("Проверяем, что в выдаче на первой странице фильмы с нужным жанром")
    public boolean checkGenreOfFirstPageMovies(String genre) {
        return allMoviesPage.checkGenreOfFirstPageMovies(genre);
    }

}
