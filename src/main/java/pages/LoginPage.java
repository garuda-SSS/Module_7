package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement email = $x("//*[@id='email']"); //Поле для почты
    private SelenideElement password = $x("//*[@id='password']"); //Поле для пароля
    private SelenideElement submitBtn = $x("//*/button"); //Кнопка для входа
    private SelenideElement enterBtn = $x("//*/a/button"); //Кнопка Вход на главной


    public LoginPage openPage() {
        open("/login");
        enterBtn.shouldBe(visible, Duration.ofSeconds(10)).click();
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

    public void submit() {
        submitBtn.click();
    }
}
