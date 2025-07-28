package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement email = $("#email"); //Поле для почты
    private SelenideElement password = $("#password"); //Поле для пароля
    private SelenideElement submitBtn = $("[type=\"submit\"]"); //Кнопка для входа



    public LoginPage openPage() {
        open("/login");
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
