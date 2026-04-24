package tasks.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
