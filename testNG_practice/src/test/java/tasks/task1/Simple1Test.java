package tasks.task1;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import tasks.task4.MethodListener;
import tasks.task6.SimpleTestParameters;

public class Simple1Test {

    @Test(groups = "slow")
    public void test1() {
        System.out.println("Мы в test1");
        Assert.fail("Блин, упал(((((");
    }

    @Test(
            dataProviderClass = SimpleTestParameters.class,
            dataProvider = "forTest1"
    )
    public void test2(String username, String password) {
        System.out.println("Мы в test2");
        System.out.printf("И тут параметры - %s / %s\n", username, password);
        Assert.assertTrue(true);
    }

    @Test(enabled = false) // Не вызовется
    public void test3() {
        System.out.println("Мы в test3");
        Assert.assertTrue(true);
    }

    @Test(groups = "fast")
    public void test4() {
        System.out.println("Мы в test4");
        throw new SkipException("Скипаю test4");
    }

    @Test(groups = "slow")
    public void test5() {
        MethodListener.threadSleep(5000);
        System.out.println("Мы в test5");
        MethodListener.threadSleep(1000);
    }

    @Test(groups = "fast")
    public void test6() {
        System.out.println("Мы в test6");
    }
}
