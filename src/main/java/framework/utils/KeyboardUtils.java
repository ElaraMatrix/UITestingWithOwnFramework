package framework.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public final class KeyboardUtils extends BaseUtility {

    private KeyboardUtils() {}

    private static final Actions actionProvider = new Actions(DriverUtils.getDriver());

    public static void keyArrowLeft() {
        log.info("press on ARROW_LEFT");
        actionProvider.sendKeys(Keys.ARROW_LEFT).build().perform();
    }

    public static void keyArrowRight() {
        log.info("press on ARROW_RIGHT");
        actionProvider.sendKeys(Keys.ARROW_RIGHT).build().perform();
    }

    public static void keyBackspace() {
        log.info("press on BACK_SPACE");
        actionProvider.sendKeys(Keys.BACK_SPACE).build().perform();
    }

}