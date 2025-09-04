import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import junit.UITest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.cinescope.api.dto.AuthResponse;
import ru.cinescope.api.steps.MovieSteps;
import ru.cinescope.api.steps.UserSteps;
import steps.AllMoviesPageSteps;
import steps.ReviewPageSteps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@UITest
public class ReviewPageTest {

    private final String comment = "Енот(@_@)";
    private final String alertDescription = "Отзыв успешно создан";
    private final int rate = 3;
    private ReviewPageSteps reviewPageSteps;
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();
    private static final UserSteps userSteps = new UserSteps();
    private static AuthResponse adminUser;
    private static final MovieSteps movieSteps = new MovieSteps();

    @BeforeAll
    public static void takeAdminUser() {
        adminUser = userSteps.userLogin("test-admin@mail.com", "KcLMmxkJMjBD1");
    }

    @AfterEach
    public void deleteComment() {
        movieSteps.deleteComment(reviewPageSteps.takeNumberOfCurrentMovie(), adminUser);
    }

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

}