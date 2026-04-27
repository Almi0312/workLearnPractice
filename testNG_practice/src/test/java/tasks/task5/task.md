## Задача 5. «Слушатель, который спасает скриншоты» (ITestListener + эмуляция WebDriver)
### Цель:
Научиться реагировать на падение теста, например, чтобы автоматически делать скриншот страницы.<br>
Мы не будем запускать реальный браузер, а просто эмулируем сохранение.

#### 📌 Задание
Создай слушатель `ScreenshotListener`, который в методе `onTestFailure` вызывает статический метод `takeScreenshot(testName)`
из класса `ScreenshotUtil`. Метод пусть просто выводит в консоль: "Фейковый скриншот для теста: `testName`" и создаёт пустой
файл с именем `testName.png`.

<details>
<summary>✏️ Скелет для самостоятельной сборки</summary>

    // ScreenshotUtil.java
    public class ScreenshotUtil {
        public static void takeScreenshot(String testName) {
            // Здесь в реальном проекте был бы WebDriver
            System.out.println("Скриншот сохранён: " + testName + ".png");
            // Можно создать пустой файл для наглядности
            new java.io.File(testName + ".png");
        }
    }
    
    // ScreenshotListener.java
    import org.testng.ITestListener;
    import org.testng.ITestResult;
    
    public class ScreenshotListener implements ITestListener {
        @Override
        public void onTestFailure(ITestResult result) {
            ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName());
        }
    }
</details>

#### 🧩 Вопросы для самопроверки:
- Где лучше разместить вызов скриншота — в onTestFailure или в afterInvocation у IInvokedMethodListener?
- Как получить не только имя метода, но и параметры теста для использования в названии скриншота? (Используй `result.getParameters()`)
