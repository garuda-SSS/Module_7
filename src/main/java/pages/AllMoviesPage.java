package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AllMoviesPage {
    private SelenideElement allMoviesLink = $x("//a[text()='Все фильмы']"); //Переход к списку фильмов с фильтрами
    private SelenideElement genre = $x("//*[@value=\"all\"]"); //Вызов фильтров по жанрам
    private ElementsCollection movies = $$x("//*[contains(@data-qa-id, 'more')]"); //Все фильмы на странице
    private SelenideElement genreDescription = $x("//*[contains(@class, 'text-lg') and contains(@class, 'mt-5')]"); // Жанр


    public AllMoviesPage setAllMoviesLink() {
        allMoviesLink.click();
        return this;
    }

    public AllMoviesPage genreList() {
        genre.click();
        return this;
    }

    public AllMoviesPage setGenre(String type) {
        $x("//span[text()='" + type + "']").click();
        return this;
    }

    public boolean check(String genre) {
        movies.shouldHave(sizeGreaterThan(0));
        boolean checkStatus = true;
        for(SelenideElement movie: movies) {
            Selenide.executeJavaScript("window.open('" + movie.getAttribute("href") + "')");
            Selenide.switchTo().window(1);
            genreDescription.shouldBe(visible);
            if (!genreDescription.has(text("Жанр: " + genre))){
                checkStatus = false;
            }
            Selenide.closeWindow();
            Selenide.switchTo().window(0);
        }
        return checkStatus;
        }
}
