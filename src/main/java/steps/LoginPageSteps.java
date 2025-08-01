package steps;

import pages.LoginPage;


public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    String userEmail = "test-admin@mail.com";
    String userPassword = "KcLMmxkJMjBD1";

    public void entrance() {
        loginPage
                .openPage()
                .enter()
                .setEmail(userEmail)
                .setPassword(userPassword)
                .submit();
    }
}