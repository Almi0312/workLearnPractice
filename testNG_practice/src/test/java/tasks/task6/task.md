## Задача 6. «Связка DataProvider и Слушателя»
### Цель:
Понять, как слушатель может видеть данные, с которыми запущен тест.

#### 📌 Что делаем
Создай тестовый класс, который принимает параметры через `@DataProvider`. Слушатель `MyFirstListener` модифицируй так, чтобы
в `onTestStart` он печатал параметры теста. Например:<br>
Запуск теста `loginTest` с параметрами: [user1, secretPassword]

<details>
<summary>✏️ Подсказка по коду</summary>

    @Override
    public void onTestStart(ITestResult result) {
        Object[] params = result.getParameters();
        System.out.println(">>> Тест " + result.getMethod().getMethodName() + " стартовал с параметрами: " + Arrays.toString(params));
    }

    // DataProvider (в отдельном классе или в том же тесте):
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
        {"user1", "pass1"},
        {"user2", "pass2"}
        };
    }
    
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Логинимся как " + username);
        Assert.assertNotNull(username);
    }
</details>

#### 🧩 Твоё задание:
- Убедись, что слушатель выводит параметры для каждого запуска.
- Подумай, что будет, если один из тестов на определённых данных упадёт — как ты можешь связать ошибку с конкретными параметрами в отчёте?
<details>
<summary>🔽️Ответ</summary>

    Использовать ITestResult.getParameters() в нужном слушателе (onTestFailure) или в цикле построения отчёта (IReporter). Это даёт тебе массив значений, с которыми запускалась каждая итерация теста.
    Теперь ты знаешь, как извлечь и вывести эти данные. Это превращает безликое «упал loginTest» в понятное «упал loginTest с пользователем user2». Сразу видно, кого винить 😉
</details>
