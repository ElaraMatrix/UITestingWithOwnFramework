package framework.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitDriverUtils extends BaseUtility {

    private static WebDriverWait wait;
    private static Wait<WebDriver> fluentWait;

    private WaitDriverUtils() {}

    public static void updateDriverWait() {
        log.info("DriverWait updating");
        wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(ConfigManager.getExplicitlyWait()));
        fluentWait = new FluentWait<>(DriverUtils.getDriver())
                .withTimeout(Duration.ofSeconds(ConfigManager.getExplicitlyWait()))
                .pollingEvery(Duration.ofMillis(ConfigManager.getFluentWaitFrequency()))
                .ignoring(NoSuchElementException.class);
    }

    public static WebDriverWait getDriverWait() {
        return wait;
    }

    public static Wait<WebDriver> getFluentWait() {
        return fluentWait;
    }

}