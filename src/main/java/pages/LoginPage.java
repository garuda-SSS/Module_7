package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement email = $x("//*[@id='email']"); //Поле для почты
    private final SelenideElement password = $x("//*[@id='password']"); //Поле для пароля
    private final SelenideElement submitBtn = $x("//*/button"); //Кнопка для входа
    private final SelenideElement enterBtn = $x("//*/a/button"); //Кнопка Вход на главной


    public LoginPage openPage() {
        open("/login");
        enterBtn.shouldBe(clickable, Duration.ofSeconds(100)).click();
        return this;
    }

    public LoginPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public LoginPage setPassword(String value) {
        password.setValue(value);
        return this;
    }

    public void clickSubmit() {
        submitBtn.click();
    }
}
