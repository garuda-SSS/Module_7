package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ReviewPage {
    private SelenideElement comment = $x("//*[@name='text']"); // Поле для комментариев
    private SelenideElement submitBtn = $x("//*[@type='submit']"); // Отправка комментария
    private SelenideElement rateList = $x("//*[@role=\"combobox\"]"); // Дропдаун с оценками
    private ElementsCollection movies = $$x("//*[contains(@data-qa-id, 'more')]"); //Все фильмы на странице
    private SelenideElement payment = $x("//*[@id=\"root\"]/div[1]/main/section/div[1]/div[2]/button"); //Переход к оплате
    private SelenideElement deleteBtn = $x("//*[text()='Удалить']"); //Пункт удалить в меню


    public ReviewPage goToPayment() {
        payment.click();
        return this;
    }

    public ReviewPage menuClick(String username) {
        $x("//h4[text()='" + username + "']/following-sibling::button[@aria-haspopup='menu']").click();
        return this;
    }

    public ReviewPage deleteClick() {
        deleteBtn.shouldBe(visible).click();
        return this;
    }



    public ReviewPage goToRandomMovie()
    {
        movies.shouldHave(sizeGreaterThan(0));
        Random random = new Random();
        movies.get(random.nextInt(movies.size()-1)).click();
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

    public void submitClick() {
        submitBtn.shouldBe(visible).click();
    }


    public String alertText(String text) {
        return $x("//*[text() = '" + text + "']").shouldBe(visible, Duration.ofSeconds(5)).text();
    }
}
