package framework.driver;

import org.openqa.selenium.WebDriver;

public class SingletonDriver {

    private static WebDriver driver = null;

    private SingletonDriver() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getDriver();
        }

        return driver;
    }

    public static void resetDriver() {
        driver = null;
    }

}