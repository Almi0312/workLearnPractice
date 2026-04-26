package tasks.task4;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.time.Instant;

public class MethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            long start = Instant.now().toEpochMilli();
            threadSleep(500);
            System.out.println("Начало теста заняло - " + Instant.now().minusMillis(start).toEpochMilli() + "мс");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            long start = Instant.now().toEpochMilli();
            threadSleep(500);
            System.out.println("Окончание теста заняло - " + Instant.now().minusMillis(start).toEpochMilli() + "мс");
        }
    }

    public static void threadSleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
