## Задача 3. «Свой мини-отчёт» (IReporter)
### Цель:
Создать кастомный отчёт, который собирает результаты ВСЕХ тестов после завершения всего набора.<br>
`IReporter` даёт доступ к полной статистике.

#### 📌 План
После прогона тестов сгенерировать простой текстовый файл `custom-report.txt`, где для каждого теста будет записано: *имя*,
*статус* и *продолжительность в миллисекундах*.

<details>
<summary>🔽 Подсказка к реализации</summary>

    Метод generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) вызывается TestNG один раз вконце. 
    Для получения результатов надо пройтись по ISuite -> ISuiteResult -> ITestContext -> ITestResult.
</details>

#### ✏️ Ключевой код:
<details>
<summary>🔽 Слушатель-генератор (SimpleReporter.java)</summary>

    import org.testng.*;
    import org.testng.xml.XmlSuite;
    
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.List;
    
    public class SimpleReporter implements IReporter {
    
        @Override
        public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, 
                                   String outputDirectory) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("custom-report.txt"))) {
                for (ISuite suite : suites) {
                    for (ISuiteResult suiteResult : suite.getResults().values()) {
                        ITestContext context = suiteResult.getTestContext();
                        for (ITestResult result : context.getPassedTests().getAllResults()) {
                            writer.println("PASSED: " + result.getMethod().getMethodName()
                                    + " [" + (result.getEndMillis() - result.getStartMillis()) + "ms]");
                        }
                        for (ITestResult result : context.getFailedTests().getAllResults()) {
                            writer.println("FAILED: " + result.getMethod().getMethodName()
                                    + " [" + (result.getEndMillis() - result.getStartMillis()) + "ms]");
                        }
                    }
                }
                System.out.println("Отчёт сохранён в custom-report.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
</details>

#### 🧩 Твоё задание
Используй те же тесты из первой задачи.
- Подключи `SimpleReporter` в `testng.xml` (вместе с `MyFirstListener` — их можно вешать сколько угодно).
- После прогона открой файл и проверь данные.

#### Идея для развития:
Добавь в отчёт информацию о параметрах теста, если они передавались через `@Parameters` или `DataProvider`
<details>
<summary>🔽 Подсказка</summary>

    ITestResult.getParameters()
</details>
