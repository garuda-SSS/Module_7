package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private final SelenideElement card = $x("//*[@name='card.cardNumber']"); //Номер карты
    private final SelenideElement holderName = $x("//*[@name='card.cardHolder']"); //Владелец карты
    private final SelenideElement cvc = $x("//*[@name='card.securityCode']"); //Cvc
    private final SelenideElement month = $x("//*[@id='month']"); //Месяц
    private final SelenideElement year = $x("//*[@id='year']"); //Год
    private final SelenideElement submitBtn = $x("//*[text()='Оплатить']"); //Кнопка оплатить


    public PaymentPage setCardNumber(String number) {
        card.shouldBe(visible).setValue(number);
        return this;
    }

    public void submitClick() {
        submitBtn.click();
    }

    public PaymentPage setCardHolder(String holder) {
        holderName.shouldBe(visible).setValue(holder);
        return this;
    }

    public void setCvc(String number) {
        cvc.shouldBe(visible).setValue(number);
    }

    public PaymentPage openMonthList() {
        month.shouldBe(visible).click();
        return this;
    }

    public PaymentPage yearListClick() {
        year.shouldBe(visible).click();
        return this;
    }

    public PaymentPage valueFromListClick(String value) {
        $x("//*[text() = '" + value + "']/parent::*[@class]").shouldBe(visible).click();
        return this;
    }

}
