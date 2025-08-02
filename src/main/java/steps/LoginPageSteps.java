package steps;

import pages.LoginPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    String userEmail;
    String userPassword;

    public LoginPageSteps loadProperties() {
        File file = new File("src/test/resources/config.properties");
        Properties properties = new Properties();

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
            userEmail = properties.getProperty("login.username");
            userPassword = properties.getProperty("login.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }

        return this;
    }

    public void entrance() {
        loginPage
                .openPage()
                .enter()
                .setEmail(userEmail)
                .setPassword(userPassword)
                .submit();
    }
}