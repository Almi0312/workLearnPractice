package workLearn.screenplay;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import workLearn.screenplay.performs.Performable;
import workLearn.screenplay.checks.Question;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class Actor {

    @Getter
    private final String name;
    private final Map<Class<? extends Ability>, Ability> abilities = new HashMap<>();

    public Actor(String name) {
        this.name = name;
    }

    /**
     * Выдает какую-то способность для пользователя
     * Это может быть обращение к апи, бд или браузеру
     * Своего рода ServiceManager
     * Реализация позволяет перезаписывать одну способность на другую по ключу
     *
     * @param ability сервис, который реализует интерфейс Ability
     */
    public <T extends Ability> T can(@Nonnull T ability) {
        abilities.put(ability.getClass(), ability);
        return ability;
    }

    // Получить способность (используется внутри действий)
    public <T extends Ability> T ability(Class<T> type) {
        T ability = (T) abilities.get(type);
        if (ability == null) {
            throw new IllegalStateException(name + " не обладает способностью " + type.getSimpleName());
        }
        return ability;
    }

    /**
     * В методе передаются какие-то действия, которые должны быть выполнены
     * В них не входят проверки как отдельные шаги
     * исключительно какие-то клики, записи в поля и так далее
     *
     * @param tasks задачи на выполнение кликов
     */
    public void performTo(Performable... tasks) {
        for (Performable task : tasks) {
            task.performAs(this);
        }
    }

    /**
     * Проверка элемента с помощью проверок Selenide
     *
     * @param elementByCondition получаем элемент для проверки
     */
    public void should(Question<SelenideElement> elementByCondition) {
        elementByCondition.answeredBy(this);
    }

    /**
     * Проверка элемента с помощью проверок AssertJ
     *
     * @param condition проверка элемента
     * @return фактическое значения (T) для продолжения цепочки
     */
    public <T> T asks(Question<T> condition) {
        return condition.answeredBy(this);
    }
}
