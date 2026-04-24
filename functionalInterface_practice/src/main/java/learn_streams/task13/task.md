### Задача R5. Генератор отчётов с разными форматами (расширенный)
Возьми задание 4 ([ReportGenerator](/learn_streams/new_tasks.md)).
Добавь возможность выводить отчёт не только в консоль, но и в файл или в строку (вернуть как `String`).

Для этого:
- Создай интерфейс ReportDestination с методом void write(String line).
- Реализуй ConsoleDestination, FileDestination, StringBuilderDestination.
- Переделай методы generateReport так, чтобы они принимали ReportDestination и использовали его для вывода.

<details about="Бонус">
<summary>🔽 Бонус</summary>
Напиши метод, который генерирует JSON-отчёт и возвращает его как String, используя StringBuilderDestination.
</details>