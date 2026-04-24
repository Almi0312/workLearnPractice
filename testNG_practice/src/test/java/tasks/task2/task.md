## Задача 2. «Меняем порядок на лету» (IMethodInterceptor)

### Цель: Научиться перехватывать список методов перед выполнением и менять их порядок или фильтровать. Это сердце интерсепторов.

#### 📌 Что делаем:
Создадим три тестовых метода без явного приоритета.

Интерсептор отсортирует их по алфавиту названий вопреки тому, как они записаны в классе.

<details>
<summary>🔽 Подсказка</summary>

    <Интерфейс IMethodInterceptor содержит единственный метод intercept(List<IMethodInstance> methods,
    ITestContext context). Он возвращает новый список методов.
</details>

## ✏️ Ключевой код:
<details>
<summary>🔽 Тестовый класс (OrderTest.java)</summary>

    import org.testng.annotations.Test;

    public class OrderTest {
        @Test
        public void bananaTest() {
            System.out.println("Я bananaTest");
        }

        @Test
        public void appleTest() {
            System.out.println("Я appleTest");
        }

        @Test
        public void cherryTest() {
            System.out.println("Я cherryTest");
        }
    }
</details>

<details>
<summary>🔽 Интерсептор (AlphabeticInterceptor.java)</summary>

    import org.testng.IMethodInstance;
    import org.testng.IMethodInterceptor;
    import org.testng.ITestContext;
    
    import java.util.Comparator;
    import java.util.List;
    import java.util.stream.Collectors;
    
    public class AlphabeticInterceptor implements IMethodInterceptor {

        @Override
        public List<IMethodInstance> intercept(List<IMethodInstance> methods, 
                                               ITestContext context) {
            // Сортируем методы по имени
            return methods.stream()
                    .sorted(Comparator.comparing(m -> m.getMethod().getMethodName()))
                    .collect(Collectors.toList());
        }

    }
</details>

<details>
<summary>🔽 Регистрация в testng.xml</summary>

    <suite name="Interceptor Suite">
      <listeners>
        <listener class-name="AlphabeticInterceptor"/>
      </listeners>
      <test name="Order Test">
      <classes>
     <class name="OrderTest"/>
    </classes>
    </test>
    </suite>
</details>

#### 🧩 Твоё задание
Запусти и проверь, что порядок вывода стал `appleTest`, `bananaTest`, `cherryTest`

#### Усложни:
добавь фильтрацию. Например, запускать только те методы, в названии которых есть слово «smoke». Верни из intercept только их.

#### Вопрос на понимание:
- Чем интерсептор принципиально отличается от обычного задания priority в аннотации @Test?
- В каком случае интерсептор незаменим?

