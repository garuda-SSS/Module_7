package junit;


import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import steps.LoginPageSteps;

public class LoginExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        LoginPageSteps page = new LoginPageSteps();
        page
                .loadProperties()
                .entrance();
    }
}
