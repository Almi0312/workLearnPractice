package learn_streams.task4;

import java.util.List;
import java.util.function.Consumer;

public class ReportGenerator {

    public static void generateHtmlReport(List<Transaction> transactions) {
        System.out.println("Генерация html отчета");
        generateReport(transactions,
                () -> System.out.println("<html>"),
                t -> System.out.println("<div>" + t.amount() + " " + t.date() + "</div>"),
                () -> System.out.println("</html>")
        );
    }

    public static void generateCsvReport(List<Transaction> transactions) {
        System.out.println("Генерация csv отчета");
        generateReport(transactions,
                () -> System.out.println("amount,date"),
                t -> System.out.println(t.amount() + "," + t.date()),
                () -> {
                }
        );
    }

    public static void generateJsonReport(List<Transaction> transactions) {
        System.out.println("Генерация json отчета");
        generateReport(transactions,
                () -> System.out.println("["),
                t -> {
                    System.out.print("{\"amount\":" + t.amount() + ",\"date\":\"" + t.date() + "\"}");
                    if (transactions.indexOf(t) < transactions.size() - 1) {
                        System.out.print(",");
                    }
                    System.out.println();
                },
                () -> System.out.println("]")
        );
    }

    private static void generateReport(List<Transaction> transactions,
                                       Runnable start,
                                       Consumer<Transaction> formatter,
                                       Runnable end) {
        start.run();
        transactions.forEach(formatter);
        end.run();
    }

    private static void generateReport(List<Transaction> transactions,
                                       String start,
                                       ReportFormatter<Transaction> formatter,
                                       String end) {
        System.out.println(start);
        transactions.forEach(formatter::format);
        System.out.println(end);
    }
}
