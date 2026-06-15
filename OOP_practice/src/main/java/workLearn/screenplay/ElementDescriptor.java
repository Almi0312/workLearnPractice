package workLearn.screenplay;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.annotation.Nonnull;

public record ElementDescriptor(
        String title,
        By locator,
        String type
) {

    public static ElementDescriptor el(@Nonnull String title,
                                       @Nonnull By locator,
                                       @Nonnull String type) {
        return new ElementDescriptor(title, locator, type);
    }

    public String getAs() {
        return type + " " + title;
    }

    public SelenideElement element() {
        return Selenide.$(locator).as(getAs());
    }

    @Override
    public String toString() {
        return "{" + type + title + "}";
    }
}
