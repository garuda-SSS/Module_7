package steps;

import io.qameta.allure.Step;
import pages.ReviewPage;

public class ReviewPageSteps {
    private final ReviewPage reviewPage = new ReviewPage();




    @Step("Публикация комметария")
    public void publishComment(String text, int rate) {
        reviewPage
                .setComment(text)
                .clickRateList()
                .setRate(rate)
                .clickSubmit();
    }

    @Step("Получение текста алерта")
    public String getAlertText(String text) {
        return reviewPage.getAlertText(text);
    }

    @Step("Переход к оплате билета")
    public PaymentPageSteps goToPayment() {
        reviewPage.clickPayment();
        return new PaymentPageSteps();
    }

    @Step("Удаление комментария")
    public void deleteComment(String username) {
        reviewPage
                .clickMenu(username)
                .clickDelete();
    }


    public int takeNumberOfCurrentMovie(){
        return reviewPage.takeNumberOfCurrentMovie();
    }

}
