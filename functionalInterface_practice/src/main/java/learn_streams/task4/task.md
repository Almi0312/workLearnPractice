## Задание 4. Рефакторинг с использованием функциональных интерфейсов
### Контекст
Умение превращать громоздкий код с анонимными классами в лямбды и функциональные цепочки — важный навык. 
Также часто требуется заменить несколько похожих методов одним параметризованным.

### Задача
Дан класс `ReportGenerator` с дублирующимися методами:

```java
public class ReportGenerator {
    
    public void generateHtmlReport(List<Transaction> transactions) {
        System.out.println("<html>");
        for (Transaction t : transactions) {
            System.out.println("<div>" + t.getAmount() + " " + t.getDate() + "</div>");
        }
        System.out.println("</html>");
    }

    public void generateCsvReport(List<Transaction> transactions) {
        System.out.println("amount,date");
        for (Transaction t : transactions) {
            System.out.println(t.getAmount() + "," + t.getDate());
        }
    }

    public void generateJsonReport(List<Transaction> transactions) {
        System.out.println("[");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.print("{\"amount\":" + t.getAmount() + ",\"date\":\"" + t.getDate() + "\"}");
            if (i < transactions.size() - 1) System.out.print(",");
            System.out.println();
        }
        System.out.println("]");
    }
}
```
Твоя задача — отрефакторить класс, чтобы избежать дублирования кода обхода коллекции и формирования вывода. <br>

Сделай следующее:

Выдели общий метод 
```java
generateReport(List<Transaction> transactions, 
Consumer<Transaction> formatter, 
Runnable header, Runnable footer);
```
который принимает действия для начала, каждой записи и конца.

Перепиши три метода через вызов generateReport с соответствующими лямбдами.

Дополнительно: Создай интерфейс `ReportFormatter` (функциональный) с методом `String format(Transaction t)`. <br>
Затем напиши метод `generateReport(List<Transaction> transactions, ReportFormatter formatter, String header, String footer)`, <br>
который будет выводить заголовок, каждую отформатированную запись и подвал. <br>
Реализуй три форматера как лямбды или ссылки на методы.<br>

Покажи итоговый код. Объясни, какие преимущества дал рефакторинг.

### Вопросы для размышления
Какие ещё способы устранения дублирования ты видишь?

Почему в данном случае использование Consumer и Runnable может быть предпочтительнее, чем передача String?