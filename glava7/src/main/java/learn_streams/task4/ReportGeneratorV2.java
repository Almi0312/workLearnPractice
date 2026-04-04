package learn_streams.task4;

import java.util.List;
import java.util.stream.IntStream;

public class ReportGeneratorV2 {

    public static void generateHtmlReport(List<Transaction> transactions) {
        System.out.println("Генерация html отчета");
        generateReport(transactions,
                "<html>",
                t -> "<div>" + t.amount() + " " + t.date() + "</div>",
                "</html>"
        );
    }

    public static void generateCsvReport(List<Transaction> transactions) {
        System.out.println("Генерация csv отчета");
        generateReport(transactions,
                "amount,date",
                t -> t.amount() + "," + t.date(),
                ""
        );
    }

    public static void generateJsonReport(List<Transaction> transactions) {
        System.out.println("Генерация json отчета");
        generateReport(transactions,
                "[",
                t -> {
                    StringBuilder result = new StringBuilder("{\"amount\":" + t.amount() + ",\"date\":\"" + t.date() + "\"}");
                    if (transactions.indexOf(t) < transactions.size() - 1) {
                        result.append(",");
                    }
                    return result.toString();
                },
                "]"
        );
    }

    private static void generateReport(List<Transaction> transactions,
                                       String start,
                                       ReportFormatter<Transaction> formatter,
                                       String end) {
        System.out.println(start);
        transactions.forEach(t -> System.out.println(formatter.format(t)));
        System.out.println(end);
    }
}
