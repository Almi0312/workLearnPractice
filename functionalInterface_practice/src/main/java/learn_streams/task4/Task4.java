package learn_streams.task4;

import java.time.LocalDate;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(100.50, LocalDate.of(2025, 3, 1)),
                new Transaction(250.00, LocalDate.of(2025, 3, 2)),
                new Transaction(75.20, LocalDate.of(2025, 3, 3))
        );
        printReports(transactions);
        System.out.println("****************************************************");
        printReportsV2(transactions);
    }

    private static void printReports(List<Transaction> transactions) {
        ReportGenerator.generateJsonReport(transactions);
        System.out.println();
        ReportGenerator.generateCsvReport(transactions);
        System.out.println();
        ReportGenerator.generateJsonReport(transactions);
    }

    private static void printReportsV2(List<Transaction> transactions) {
        ReportGeneratorV2.generateJsonReport(transactions);
        System.out.println();
        ReportGeneratorV2.generateCsvReport(transactions);
        System.out.println();
        ReportGeneratorV2.generateJsonReport(transactions);
    }

}
