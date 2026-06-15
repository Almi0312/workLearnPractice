package workLearn.screenplay.checks.questions;

import com.codeborne.selenide.SelenideElement;
import workLearn.screenplay.ElementDescriptor;
import workLearn.screenplay.checks.Question;
import workLearn.screenplay.condition_types.ClickableCondition;
import workLearn.screenplay.condition_types.VisibleCondition;

import javax.annotation.Nonnull;

public class Should {

    public static Question<SelenideElement> beVisible(@Nonnull ElementDescriptor descriptor,
                                                      @Nonnull VisibleCondition condition) {
        return actor -> descriptor.element().shouldBe(condition.perform(descriptor));
    }

    public static Question<SelenideElement> beClickable(@Nonnull ElementDescriptor descriptor,
                                                        @Nonnull ClickableCondition condition) {
        return actor -> descriptor.element().shouldBe(condition.perform(descriptor));
    }

}
