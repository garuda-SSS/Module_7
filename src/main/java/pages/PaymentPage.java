package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private SelenideElement card = $x("//*[@name='card.cardNumber']"); //Номер карты
    private SelenideElement holderName = $x("//*[@name='card.cardHolder']"); //Владелец карты
    private SelenideElement cvc = $x("//*[@name='card.securityCode']"); //Cvc
    private SelenideElement month = $x("//*[@id='month']"); //Месяц
    private SelenideElement year = $x("//*[@id='year']"); //Год
    private SelenideElement submit = $x("//*[text()='Оплатить']"); //Кнопка оплатить


    public PaymentPage setCardNumber(String number) {
        card.shouldBe(visible).setValue(number);
        return this;
    }

    public PaymentPage submitClick() {
        submit.click();
        return this;
    }

    public PaymentPage setCardHolder(String holder) {
        holderName.shouldBe(visible).setValue(holder);
        return this;
    }

    public PaymentPage setCvc(String number) {
        cvc.shouldBe(visible).setValue(number);
        return this;
    }

    public PaymentPage monthList() {
        month.shouldBe(visible).click();
        return this;
    }

    public PaymentPage yearList() {
        year.shouldBe(visible).click();
        return this;
    }

    public PaymentPage valueFromList(String value) {
        $x("//*[text() = '" + value + "']/parent::*[@class]").shouldBe(visible).click();
        return this;
    }

}
