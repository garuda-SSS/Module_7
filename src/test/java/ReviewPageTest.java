import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import steps.ReviewPageSteps;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class ReviewPageTest {

    String comment = "Енот(@_@)";
    String alertDiscription = "Отзыв успешно создан";
    int rate = 3;
    ReviewPageSteps reviewPageSteps = new ReviewPageSteps();

    @Test
    public void publishCommentTest() {
        reviewPageSteps
                .openMovie()
                .publishComment(comment, rate);
        assertThat(reviewPageSteps.alertText(alertDiscription)).isEqualTo(alertDiscription);
    }

    @AfterEach
    public void delete() {
        reviewPageSteps.deleteComment("Test Admin");
    }

}