package steps;

import io.qameta.allure.Step;
import pages.ReviewPage;

public class ReviewPageSteps {
    ReviewPage reviewPage = new ReviewPage();


    @Step("Открытие произвольного фильма")
    public ReviewPageSteps openMovie() {
        reviewPage.goToRandomMovie();
        return this;
    }

    @Step("Публикация комметария")
    public ReviewPageSteps publishComment(String text, int rate) {
        reviewPage
                .setComment(text)
                .clickRateList()
                .setRate(rate)
                .submitClick();
        return this;
    }

    @Step("Получение текста алерта")
    public String alertText(String text) {
        return reviewPage.alertText(text);
    }

    @Step("Переход к оплате билета")
    public void goToPayment() {
        reviewPage.goToPayment();
    }

    @Step("Удаление комментария")
    public void deleteComment(String username) {
        reviewPage
                .menuClick(username)
                .deleteClick();
    }

}
