package steps;

import pages.ReviewPage;

public class ReviewPageSteps {
    ReviewPage reviewPage = new ReviewPage();

    public ReviewPageSteps openMovie() {
        reviewPage.goToRandomMovie();
        return this;
    }

    public ReviewPageSteps publishComment(String text, int rate) {
        reviewPage
                .setComment(text)
                .clickRateList()
                .setRate(rate)
                .submitBtnClick();
        return this;
    }


    public String alertText(String text) {
        return reviewPage.alertText(text);
    }

    public void goToPayment() {
        reviewPage.goToPayment();
    }

}
