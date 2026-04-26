## Задача 4. «Хронометраж каждого шага» (IInvokedMethodListener)
### Цель: Этот слушатель срабатывает ДО и ПОСЛЕ каждого вызываемого метода: не только тестов, но и конфигурационных (
@BeforeMethod, @AfterMethod и т.д.). Отлично для точных замеров времени.

#### 📌 Что делаем
Создадим слушатель, который засекает время выполнения любого метода и печатает его в консоль.

#### ✏️ Основа
<details>
<summary>🔽 Слушатель (ExecutionTimer.java)</summary>

    import org.testng.IInvokedMethod;
    import org.testng.IInvokedMethodListener;
    import org.testng.ITestResult;
    
    public class ExecutionTimer implements IInvokedMethodListener {
    
        private long startTime;
    
        @Override
        public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
            startTime = System.currentTimeMillis();
            System.out.println(">>> Запускаем: " + method.getTestMethod().getMethodName());
        }
    
        @Override
        public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
            long elapsed = System.currentTimeMillis() - startTime;
            System.out.println(">>> Завершён: " + method.getTestMethod().getMethodName() 
                               + " за " + elapsed + " мс");
        }
    }
</details>

#### Обрати внимание:
Не забудь проверить, что method.isTestMethod() — true, иначе вывод будет и для @BeforeMethod и т.п.

#### 🧩 Твоё задание
Примени слушатель к тестам, где один из методов искусственно замедлен (`Thread.sleep(1000)`). Убедись, что время логируется правильно.

#### Подумай:
Чем этот слушатель полезнее, чем просто System.currentTimeMillis() внутри тела теста?
<details>
<summary>🔽 Ответ</summary>

    Мы разделяем логику замера и бизнес-логику теста, можем легко включить/отключить замер.
</details>

