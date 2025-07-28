package steps;

import pages.LoginPage;


public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    String userEmail = "";
    String userPassword = "";

    public void entrance() {
        loginPage
                .openPage()
                .setEmail(userEmail)
                .setPassword(userPassword)
                .submit();
    }
}