package tasks.task5;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.takeScreenshot(result.getName());
    }
}
