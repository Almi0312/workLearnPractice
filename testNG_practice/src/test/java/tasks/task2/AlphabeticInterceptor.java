package tasks.task2;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.internal.MethodInstance;
import tasks.task1.Simple1Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlphabeticInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        String test = System.getProperty("testFilter");
        List<IMethodInstance> methodInstances;
        switch (test) {
            case "task1" -> methodInstances = list.stream()
                    .filter(m -> m.getMethod().getRealClass().equals(Simple1Test.class))
                    .toList();
            case "task2" -> methodInstances = list.stream()
                    .sorted(Comparator.comparing(m -> m.getMethod().getMethodName()))
                    .filter(m -> m.getMethod().getRealClass().equals(Simple2Test.class))
                    .filter(m -> m.getMethod().getMethodName().endsWith("Smoke"))
                    .toList();
            default -> methodInstances = list;
        }
        return methodInstances;
    }
}
