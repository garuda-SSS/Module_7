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

    public void clickSubmit() {
        submitBtn.click();
    }

    public PaymentPage setCardHolder(String holder) {
        holderName.shouldBe(visible).setValue(holder);
        return this;
    }

    public void setCvc(String number) {
        cvc.shouldBe(visible).setValue(number);
    }

    public PaymentPage selectMonth(String monthName) {
        month.shouldBe(visible).click();
        this.selectValueFromList(monthName);
        return this;
    }

    public void selectYear(String yearNumber) {
        year.shouldBe(visible).click();
        this.selectValueFromList(yearNumber);
    }

    private void selectValueFromList(String value) {
        $x("//*[text() = '" + value + "']/parent::*[@class]").shouldBe(visible).click();
    }

}
