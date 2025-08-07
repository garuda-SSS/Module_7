package steps;

import io.qameta.allure.Step;
import pages.AllMoviesPage;

public class AllMoviesPageSteps {
    private AllMoviesPage allMoviesPage = new AllMoviesPage();

    @Step("Переходим к списку фильмов")
    public AllMoviesPageSteps openAllMovies() {
        allMoviesPage.allMoviesLinkClick();
        return this;
    }

    @Step("Устанавливаем фильтр по жанру")
    public AllMoviesPageSteps useGenreFilter(String genre) {
        allMoviesPage
                .openGenreDropdown()
                .setGenre(genre);
        return this;
    }

    @Step("Проверяем, что в выдаче на первой странице фильмы с нужным жанром")
    public boolean genreCheck(String genre) {
        return allMoviesPage.checkGenre(genre);
    }

}
