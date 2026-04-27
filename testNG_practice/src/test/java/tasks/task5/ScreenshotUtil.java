package tasks.task5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class ScreenshotUtil {

    public static void takeScreenshot(String name) {
        String screenName = name + "_" + LocalDateTime.now().getNano();
        System.out.printf("Фейковый скриншот для теста: %s\n", screenName);
        try {
            Files.createDirectory(Path.of("./testNG_practice/build/failed_screenshots"));
            Files.createFile(Path.of("./testNG_practice/build/failed_screenshots/" + screenName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException("Чет не то " + e.getMessage());
        }
    }
}
