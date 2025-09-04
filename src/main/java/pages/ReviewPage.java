package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.time.Duration;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ReviewPage {
    private final SelenideElement comment = $x("//*[@name='text']"); // Поле для комментариев
    private final SelenideElement submitBtn = $x("//*[@type='submit']"); // Отправка комментария
    private final SelenideElement rateList = $x("//*[@role=\"combobox\"]"); // Дропдаун с оценками
    private final SelenideElement paymentBtn = $x("//*[@id=\"root\"]/div[1]/main/section/div[1]/div[2]/button"); //Переход к оплате
    private final SelenideElement deleteBtn = $x("//*[text()='Удалить']"); //Пункт удалить в меню


    public void clickPayment() {
        paymentBtn.click();
    }

    public ReviewPage clickMenu(String username) {
        $x("//h4[text()='" + username + "']/following-sibling::button[@aria-haspopup='menu']").click();
        return this;
    }

    public void clickDelete() {
        deleteBtn.shouldBe(visible).click();
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

    public void clickSubmit() {
        submitBtn.shouldBe(visible).click();
    }


    public String getAlertText(String text) {
        return $x("//*[text() = '" + text + "']").shouldBe(visible, Duration.ofSeconds(5)).text();
    }

    public int takeNumberOfCurrentMovie() {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Pattern pattern = Pattern.compile("/(\\d+)$");
        Matcher matcher = pattern.matcher(currentUrl);

        if (matcher.find()) {
            String numberStr = matcher.group(1);
            try {
                return Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }
}

