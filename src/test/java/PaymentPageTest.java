import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.PaymentPageSteps;
import steps.ReviewPageSteps;

import static org.assertj.core.api.Assertions.assertThat;


@UITest
public class PaymentPageTest {

    String alertDiscription = "Оплата прошла успешно";
    PaymentPageSteps paymentPageSteps = new PaymentPageSteps();
    ReviewPageSteps reviewPageSteps = new ReviewPageSteps();

    @Test
    public void publishCommentTest() {
        reviewPageSteps
                .openMovie()
                .goToPayment();

        paymentPageSteps
                .cardInfo("4242424242424242", "Ttttt", "123")
                .dateSet("Декабрь", "2025")
                .buttonClick();
        assertThat(reviewPageSteps.alertText(alertDiscription)).isEqualTo(alertDiscription);
    }


}
