package steps;

import pages.LoginPage;


public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    String userEmail = "sipin1997@gmail.com";
    String userPassword = "KPfghucwi5WQ7Fg";

    public void entrance() {
        loginPage
                .openPage()
                .setEmail(userEmail)
                .setPassword(userPassword)
                .submit();
    }
}