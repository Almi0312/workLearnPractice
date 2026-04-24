### Задача F3. Каррирование на практике (без трёх чисел)
Создай функцию, которая «запоминает» порог (`threshold`) и затем проверяет, превышает ли переданное число этот порог.

<details about="Подсказка">
<summary>🔽 Подсказка</summary>

Function &lt;Integer, Predicate&lt;Integer&gt;&gt; isGreaterThan = threshold -> value -> value > threshold;
</details>

Используй её, чтобы получить:
- isGreaterThan10 — предикат, проверяющий, что число > 10.
- isGreaterThan100 — проверяющий, что число > 100.

Затем отфильтруй список чисел с помощью этих предикатов (используй `stream().filter()`).
