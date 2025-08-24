package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage();
    private static String userEmail;
    private static String userPassword;


    static {
        loadProperties();
    }

    private static void  loadProperties() {
        File file = new File("src/test/resources/config.properties");
        Properties properties = new Properties();

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
            userEmail = properties.getProperty("login.username");
            userPassword = properties.getProperty("login.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    @Step("Авторизация")
    public void entrance() {
        loginPage
                .openPage()
                .setEmail(userEmail)
                .setPassword(userPassword)
                .submitClick();
    }
}