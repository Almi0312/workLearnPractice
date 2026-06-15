package workLearn.screenplay.condition_types;

import com.codeborne.selenide.WebElementCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;

@AllArgsConstructor
@Getter
public enum VisibleCondition implements Condition {
    VISIBLE("присутству(ет/ют)", true, visible),
    NOT_VISIBLE("отсутству(ет/ют)", false, not(visible));

    private final String name;
    private final boolean booleanValue;
    private final WebElementCondition condition;

    @Override
    public String getConditionReportValue() {
        return booleanValue ? NOT_VISIBLE.name : VISIBLE.name;
    }

    @Override
    public boolean asBoolean() {
        return booleanValue;
    }

    @Override
    public String toString() {
        return getName();
    }
}
