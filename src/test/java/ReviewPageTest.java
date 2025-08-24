import io.qameta.allure.Allure;
import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ReviewPageSteps;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class ReviewPageTest {

    String comment = "Енот(@_@)";
    String alertDescription = "Отзыв успешно создан";
    int rate = 3;
    ReviewPageSteps reviewPageSteps = new ReviewPageSteps();

    @Test
    @DisplayName("Тест публикации комментария")  // Будет отображаться вместо имени метода
    public void publishCommentTest() {
        reviewPageSteps
                .openMovie()
                .publishComment(comment, rate);
        Allure.step("Сравниванием фактический текст появившегося алерта с ожидаемым", () -> {
        assertThat(reviewPageSteps.getAlertText(alertDescription)).isEqualTo(alertDescription);
        });
    }

    @AfterEach
    public void deleteComment() {
        reviewPageSteps.deleteComment("Test Admin");
    }

}