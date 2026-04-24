### Задача R3. Обработка опций с Function и Optional
Дан метод `String process(String input, Function<String, String> processor)`, который применяет processor к `input`, если `input` не `null``. 
Напиши этот метод, используя `Optional.ofNullable(input).map(processor).orElse(null)`.

Затем покажи цепочку преобразований:
- Удалить пробелы.
- Перевести в верхний регистр.
- Обрезать до 10 символов.
  Сделай так, чтобы если на любом шаге получился `null`, результат был `null`.

