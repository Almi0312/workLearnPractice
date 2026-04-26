package tasks.task3;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class ReportTxt implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println(">>> Создаю репорт");
        try (PrintWriter writer = new PrintWriter(new FileWriter("result2234"))) {
            for (ISuite suite : suites) {
                for (ISuiteResult suiteResult : suite.getResults().values()) {
                    ITestContext tests = suiteResult.getTestContext();
                    writeResultInFile(tests.getFailedTests().getAllResults(), "[FAILED]", writer);
                    writeResultInFile(tests.getPassedTests().getAllResults(), "[PASSED]", writer);
                }
            }
            System.out.println(">>> Отчет должен быть готов");
        } catch (IOException e) {
            System.out.println(">>> Отчет не готов из за ошибки: " + e.getCause());
        }
    }

    private static void writeResultInFile(Set<ITestResult> tests, String status, PrintWriter writer) {
        for (ITestResult result : tests) {
            String testResultTxt = format("%s %s %s", result.getName(), status, result.getEndMillis() - result.getStartMillis());
            writer.println(testResultTxt);
        }
    }
}
