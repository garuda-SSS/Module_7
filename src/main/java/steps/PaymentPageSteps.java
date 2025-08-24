package steps;

import io.qameta.allure.Step;
import pages.PaymentPage;

public class PaymentPageSteps {
    private final PaymentPage paymentPage = new PaymentPage();

    @Step("Ввод номера, владельца и CVC карты")
    public PaymentPageSteps setCardInfo(String number, String holder, String cvc) {
        paymentPage
                .setCardNumber(number)
                .setCardHolder(holder)
                .setCvc(cvc);
        return this;
    }

    @Step("Ввод даты окончания действия карты")
    public PaymentPageSteps dateSet(String month, String year) {
        paymentPage
                .openMonthList()
                .valueFromListClick(month)
                .yearListClick()
                .valueFromListClick(year);
        return this;
    }

    @Step("Нажимает кнопку Оплатить")
    public void buttonClick() {
        paymentPage
                .submitClick();
    }

}
