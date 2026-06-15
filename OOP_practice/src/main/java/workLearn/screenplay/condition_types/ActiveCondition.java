package workLearn.screenplay.condition_types;

import com.codeborne.selenide.WebElementCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.codeborne.selenide.Condition.*;

@AllArgsConstructor
@Getter
public enum ActiveCondition implements Condition {
    ACTIVE("включен(ы)", true, enabled),
    NOT_ACTIVE("отключен(ы)", false, disabled);

    private final String name;
    private final boolean booleanValue;
    private final WebElementCondition condition;

    @Override
    public String getConditionReportValue() {
        return asBoolean() ? NOT_ACTIVE.name : ACTIVE.name;
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
