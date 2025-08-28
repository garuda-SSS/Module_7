package steps;

import io.qameta.allure.Step;
import pages.AllMoviesPage;

public class AllMoviesPageSteps {
    private final AllMoviesPage allMoviesPage = new AllMoviesPage();

    @Step("Переходим к списку фильмов")
    public AllMoviesPageSteps openAllMovies() {
        allMoviesPage.clickAllMoviesLink();
        return this;
    }

    @Step("Устанавливаем фильтр по жанру")
    public void setGenreFilter(String genre) {
        allMoviesPage
                .setGenre(genre);
    }

    @Step("Проверяем, что в выдаче на первой странице фильмы с нужным жанром")
    public boolean verifyGenreOfMovies(String genre) {
        return allMoviesPage.verifyGenreOfMovies(genre);
    }

    @Step("Открытие произвольного фильма")
    public ReviewPageSteps openMovie() {
        allMoviesPage.goToRandomMovie();
        return new ReviewPageSteps();
    }

}
