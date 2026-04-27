package tasks.task1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ClassWithListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Object[] params = result.getParameters();
        System.out.printf(">>> Тест %s стартовал с параметрами %s\n", result.getMethod().getMethodName(), Arrays.toString(params));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf(">>> Тест %s УСПЕШНО завершен\n", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf(">>> Тест %s УПАЛ с ошибкой %s\n", result.getMethod().getMethodName(), result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.printf(">>> Тест %s был пропущен\n", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.printf(">>> Тест %s упал, но на %d успешен\n", result.getMethod().getMethodName(), result.getMethod().getSuccessPercentage());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.printf(">>> Тест %s упал из за таймаута(\n", result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(">>> Тест стартовал из метода ClassWithListener.onStart()");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(">>> Тест финишировал в методе ClassWithListener.onFinish");
    }
}
