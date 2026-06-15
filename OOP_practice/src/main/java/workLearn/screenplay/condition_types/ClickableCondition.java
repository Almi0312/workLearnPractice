package workLearn.screenplay.condition_types;

import com.codeborne.selenide.WebElementCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.not;

@AllArgsConstructor
@Getter
public enum ClickableCondition implements Condition {
    CLICKABLE("кликабел(ен/ьны)", true, clickable),
    NOT_CLICKABLE("не кликабел(ен/ьны)", false, not(clickable));

    private final String name;
    private final boolean asBoolean;
    private final WebElementCondition condition;

    @Override
    public String getConditionReportValue() {
        return asBoolean() ? NOT_CLICKABLE.name : CLICKABLE.name;
    }

    @Override
    public boolean asBoolean() {
        return asBoolean;
    }

    @Override
    public String toString() {
        return getName();
    }
}
