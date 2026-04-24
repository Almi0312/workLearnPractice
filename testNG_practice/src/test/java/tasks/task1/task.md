## Задача 1. «Здравствуй, Слушатель!» (ITestListener)

### Цель: Понять, как TestNG оповещает нас о событиях теста: старт, успех, провал, пропуск.

Ты напишешь свой первый слушатель, который просто выводит сообщения в консоль, и подключишь его.

#### 📌 План действий:

- Создай тестовый класс с одним успешным и одним падающим методом.
- Создай класс, реализующий интерфейс ITestListener.
- Зарегистрируй слушатель в testng.xml.
- Запусти и посмотри на порядок сообщений.

#### ✏️ Примеры кода (основа)

<details about="SimpleTest">
<summary>🔽 Тестовый класс (SimpleTest.java)</summary>

    import org.testng.Assert
    import org.testng.annotations.Test;
    
    public class SimpleTest {

        @Test
        public void successfulTest() {
            System.out.println("Выполняется успешный тест");
            Assert.assertTrue(true);
        }
    
        @Test
        public void failingTest() {
            System.out.println("Выполняется падающий тест");
            Assert.fail("Я специально упал!");
        }
    }

</details>

<details>
<summary>🔽 Слушатель (MyFirstListener.java)</summary>

    import org.testng.ITestListener;
    import org.testng.ITestResult;
    
    public class MyFirstListener implements ITestListener {

        @Override
        public void onTestStart(ITestResult result) {
            System.out.println(">>> Тест " + result.getMethod().getMethodName() + " стартовал");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println(">>> Тест " + result.getMethod().getMethodName() + " УСПЕШНО завершён");
        }
    
        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println(">>> Тест " + result.getMethod().getMethodName() + " УПАЛ с ошибкой: "
                    + result.getThrowable().getMessage());
        }
        // Остальные методы интерфейса можешь оставить пустыми

    }
</details>

<details>
<summary>🔽 Файл testng.xml</summary>

    <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
    <suite name="Suite with Listener">
        <listeners>
            <listener class-name="MyFirstListener"/>
        </listeners>
        <test name="Simple Tests">
            <classes>
                <class name="SimpleTest"/>
            </classes>
        </test>
    </suite>
</details>

#### 🧩 Твоё задание:

- Запусти тесты и убедись, что слушатель написал по два сообщения на каждый тест.
- Попробуй добавить ещё один тест, который пропускается (`@Test(enabled = false)`). Реализуй метод `onTestSkipped()` в слушателе и проверь, что он вызывается.
- Подумай: Почему слушатель удобнее, чем просто писать `System.out.println` внутри каждого теста?
