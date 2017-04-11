package Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by EugenKrasotkin on 4/10/2017.
 */
public class InstanPage {
    private static WebDriver driver;

    private InstanPage() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void close() {
        driver.quit();
        driver = null;
    }
}