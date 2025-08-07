import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.PaymentPageSteps;
import steps.ReviewPageSteps;

import static org.assertj.core.api.Assertions.assertThat;


@UITest
public class PaymentPageTest {


    String cardNumber = "4242424242424242";
    String cardHolder = "Ttttt";
    String cardCvc = "123";
    String cardMonth = "Декабрь";
    String cardYear = "2025";
    String alertDiscription = "Оплата прошла успешно";
    PaymentPageSteps paymentPageSteps = new PaymentPageSteps();
    ReviewPageSteps reviewPageSteps = new ReviewPageSteps();

    @Test
    public void publishCommentTest() {
        reviewPageSteps
                .openMovie()
                .goToPayment();

        paymentPageSteps
                .setCardInfo(cardNumber, cardHolder, cardCvc)
                .dateSet(cardMonth, cardYear)
                .buttonClick();
        assertThat(reviewPageSteps.alertText(alertDiscription)).isEqualTo(alertDiscription);
    }


}
