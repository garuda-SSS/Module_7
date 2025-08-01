package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ReviewPage {
    private SelenideElement comment = $x("//*[@name='text']"); // Поле для комментариев
    private SelenideElement submitBtn = $x("//*[@type='submit']"); // Отправка комментария
    private SelenideElement rateList = $x("//*[@role=\"combobox\"]"); // Дропдаун с оценками
    private ElementsCollection movies = $$x("//*[contains(@data-qa-id, 'more')]"); //Все фильмы на странице
    private SelenideElement alert = $x("//*[text() = 'Отзыв успешно создан']"); //Странный алерт
    private SelenideElement payment = $x("//*[@id=\"root\"]/div[1]/main/section/div[1]/div[2]/button"); //Переход к оплате


    public ReviewPage goToPayment() {
        payment.click();
        return this;
    }

    public ReviewPage goToRandomMovie() {
        movies.get(5).click();
        return this;
    }

    public ReviewPage setComment(String text) {
        comment.shouldBe(visible).setValue(text);
        return this;
    }


    public ReviewPage clickRateList() {
        rateList.shouldBe(visible).click();
        return this;
    }

    public ReviewPage setRate(int rate) {
        $x("(//*[@role='option'])[" + rate + "]").shouldBe(visible).click();
        return this;
    }

    public void submitBtnClick() {
        submitBtn.shouldBe(visible).click();
    }


    public String alertText(String text) {
        return $x("//*[text() = '" + text + "']").shouldBe(visible, Duration.ofSeconds(5)).text();
    }
}
