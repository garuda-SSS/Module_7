import junit.SelenideExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.LoginPageSteps;

@ExtendWith(SelenideExtension.class)
public class AllMoviesPageTest {

    LoginPageSteps q = new LoginPageSteps();

    @Test
    public void justTest(){
    q.entrance();
    }
}
