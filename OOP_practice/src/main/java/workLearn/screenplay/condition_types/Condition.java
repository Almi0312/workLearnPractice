package workLearn.screenplay.condition_types;

import com.codeborne.selenide.WebElementCondition;
import workLearn.screenplay.ElementDescriptor;

public interface Condition {

    boolean asBoolean();

    String getName();

    WebElementCondition getCondition();

    String getConditionReportValue();

    default WebElementCondition perform(ElementDescriptor descriptor) {
        return getCondition().because(
                "Элемент {%s} %s".formatted(descriptor.getAs(), getConditionReportValue())
        );
    }
}
