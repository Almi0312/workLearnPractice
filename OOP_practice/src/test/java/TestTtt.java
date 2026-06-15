import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import workLearn.screenplay.Actor;
import workLearn.screenplay.ElementDescriptor;
import workLearn.screenplay.condition_types.VisibleCondition;

import static workLearn.screenplay.performs.ClickOnElement.clickIfShouldBeClickable;
import static workLearn.screenplay.checks.questions.Should.beVisible;
import static workLearn.screenplay.performs.ClickOnElement.click;
import static workLearn.screenplay.ElementDescriptor.el;

public class TestTtt {

    @Test
    public void test() {
        Actor vasya = new Actor("vasya");
        ElementDescriptor submitButton = el("submit", By.xpath(""), "кнопка");
        ElementDescriptor retrySubmitButton = el("Retry submit", By.xpath(""), "кнопка");
        vasya.performTo(
                clickIfShouldBeClickable(submitButton),
                click(retrySubmitButton)
        );
        vasya.should(beVisible(retrySubmitButton, VisibleCondition.VISIBLE));
    }
}
