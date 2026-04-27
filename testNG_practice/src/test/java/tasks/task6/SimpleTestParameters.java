package tasks.task6;

import org.testng.annotations.DataProvider;

public class SimpleTestParameters {

    @DataProvider(name = "forTest1")
    public Object[][] dsa() {
        return new Object[][]{
                {"user1", "secretPassword1"},
                {"user2", "secretPassword2"}
        };
    }
}
