import io.qameta.allure.Allure;
import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import steps.ReviewPageSteps;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class ReviewPageTest {

    private final String comment = "Енот(@_@)";
    private final String alertDescription = "Отзыв успешно создан";
    private final int rate = 3;
    private ReviewPageSteps reviewPageSteps;
    private final AllMoviesPageSteps allMoviesPageSteps= new AllMoviesPageSteps();

    @Test
    @DisplayName("Тест публикации комментария")  // Будет отображаться вместо имени метода
    public void publishCommentTest() {
        reviewPageSteps = allMoviesPageSteps.openMovie();
        reviewPageSteps
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