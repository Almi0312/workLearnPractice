## Задача 7. «Групповые приключения» (работа с группами через аннотации и слушатели)
### Цель:
Понять, как реагировать на принадлежность тестов к группам, и даже менять поведение тестов в зависимости от группы при помощи `IAnnotationTransformer`

#### 📌 Задача-минимум
Используй `IAnnotationTransformer` — это слушатель, который позволяет изменять аннотации тестов во время загрузки классов.<br>
Например, установить всем тестам из группы slow таймаут 5000 мс, даже если в коде он не задан.

<details>
<summary>✏️ Набросок код</summary>

    import org.testng.IAnnotationTransformer;
    import org.testng.annotations.ITestAnnotation;
    import java.lang.reflect.Constructor;
    import java.lang.reflect.Method;
    
    public class SlowTestTransformer implements IAnnotationTransformer {
        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            // Проверяем, есть ли у метода группа "slow"
            if (testMethod != null) {
                String[] groups = annotation.getGroups();
                for (String group : groups) {
                    if ("slow".equals(group)) {
                        annotation.setTimeOut(5000);
                        break;
                    }
                }
            }
        }
    }
</details>
Тестовые методы разметь так: `@Test(groups = "slow")` и `@Test(groups = "fast")`.
В `testng.xml` добавь слушатель `SlowTestTransformer` так же, как и другие.

#### 🧩 Твоё задание
- Проверь, что тест из группы `slow` действительно получает таймаут (может упасть, если будет длиться дольше 5 сек).
- Подумай, где ещё может пригодиться `IAnnotationTransformer`? (например, динамическое добавление `invocationCount` или `enabled = false` на основании окружения).
