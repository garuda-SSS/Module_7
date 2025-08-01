package steps;

import pages.PaymentPage;

public class PaymentPageSteps {
    PaymentPage paymentPage = new PaymentPage();

    public PaymentPageSteps cardInfo(String number, String holder, String cvc) {
        paymentPage
                .setCardNumber(number)
                .setCardHolder(holder)
                .setCvc(cvc);
        return this;
    }

    public PaymentPageSteps dateSet(String month, String year) {
        paymentPage
                .monthList()
                .valueFromList(month)
                .yearList()
                .valueFromList(year);
        return this;
    }

    public PaymentPageSteps buttonClick() {
        paymentPage
                .submitClick();
        return this;
    }

}
