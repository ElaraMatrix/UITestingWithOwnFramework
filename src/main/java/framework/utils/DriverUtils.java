package framework.utils;

import framework.driver.SingletonDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public final class DriverUtils extends BaseUtility {

    private static WebDriver driver;

    private DriverUtils() {}

    public static void initialize(int windowWidth, int windowHeight, int implicitlyWaitSeconds) {
        log.warn("initialization driver with " + windowWidth + "x" + windowHeight);
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
        driver.manage().window().setSize(new Dimension(windowWidth, windowHeight));
        WaitDriverUtils.updateDriverWait();
    }

    public static void initialize(int implicitlyWaitSeconds) {
        log.warn("initialization driver");
        driver = SingletonDriver.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWaitSeconds));
        driver.manage().window().maximize();
        WaitDriverUtils.updateDriverWait();
    }

    public static void loadURL(String URL) {
        log.info("URL loading");
        SingletonDriver.getDriver().get(URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit() {
        log.warn("driver quiting");
        driver.quit();
        SingletonDriver.resetDriver();
    }

    public static void close() {
        if (driver.getWindowHandles().size() > 1) {
            log.info("window closing");
            driver.close();
        } else {
            driver.quit();
        }
    }

    public static void setImplicitlyWait(int seconds) {
        log.warn("implicit wait setting to " + seconds + " seconds");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

}