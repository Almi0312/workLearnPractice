package tasks.task7;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SpeedTestTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod != null) {
            String[] groups = annotation.getGroups();
            for (String group : groups) {
                if ("slow".equals(group)) {
                    System.out.println("Тест " + testMethod.getName() + " slow и ставится ограничение по работе в 5сек");
                    annotation.setTimeOut(5000);
                    break;
                }
            }
        }
    }
}
