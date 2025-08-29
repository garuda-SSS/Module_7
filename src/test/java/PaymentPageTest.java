import io.qameta.allure.Allure;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import steps.PaymentPageSteps;
import steps.ReviewPageSteps;

import static org.assertj.core.api.Assertions.assertThat;


@UITest
public class PaymentPageTest {


    private final String cardNumber = "4242424242424242";
    private final String cardHolder = "Ttttt";
    private final String cardCvc = "123";
    private final String cardMonth = "Декабрь";
    private final String cardYear = "2025";
    private final String alertDescription = "Оплата прошла успешно";
    private  PaymentPageSteps paymentPageSteps;
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();
    private ReviewPageSteps reviewPageSteps;

    @Test
    @DisplayName("Тест оплаты билета")  // Будет отображаться вместо имени метода
    public void publishCommentTest() {
        reviewPageSteps = allMoviesPageSteps.openMovie();
        paymentPageSteps = reviewPageSteps.goToPayment();
        paymentPageSteps
                .setCardInfo(cardNumber, cardHolder, cardCvc)
                .setDate(cardMonth, cardYear)
                .clickButton();
        Allure.step("Сравниванием фактический текст появившегося алерта с ожидаемым", () -> {
            assertThat(reviewPageSteps.getAlertText(alertDescription)).isEqualTo(alertDescription);
        });

    }


}
