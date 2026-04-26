package tasks.task1;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import tasks.task4.MethodListener;

public class Simple1Test {

    @Test
    public void test1() {
        System.out.println("Мы в test1");
        Assert.fail("Блин, упал(((((");
    }

    @Test
    public void test2() {
        System.out.println("Мы в test2");
        Assert.assertTrue(true);
    }

    @Test(enabled = false) // Не вызовется
    public void test3() {
        System.out.println("Мы в test3");
        Assert.assertTrue(true);
    }

    @Test
    public void test4() {
        System.out.println("Мы в test4");
        throw new SkipException("Скипаю test4");
    }

    @Test
    public void test5() {
        MethodListener.threadSleep(1000);
        System.out.println("Мы в test5");
        MethodListener.threadSleep(1000);
    }
}
