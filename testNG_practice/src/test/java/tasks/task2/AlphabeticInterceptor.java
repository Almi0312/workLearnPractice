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

    public static final String DtaskFilter = "taskFilter";

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> methodInstances;
        switch (System.getProperty(DtaskFilter)) {
            case "task1", "task3", "task4" -> methodInstances = list.stream()
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
