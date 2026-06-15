package workLearn.screenplay.performs;

import workLearn.screenplay.ElementDescriptor;

import javax.annotation.Nonnull;

import static workLearn.screenplay.condition_types.ClickableCondition.CLICKABLE;

public class ClickOnElement {

    private ClickOnElement() {
    }

    public static Performable click(@Nonnull ElementDescriptor descriptor) {
        return actor -> descriptor.element().click();
    }

    public static Performable clickIfShouldBeClickable(@Nonnull ElementDescriptor descriptor) {
        return actor -> descriptor.element().shouldBe(CLICKABLE.perform(descriptor))
                .click();
    }

}
