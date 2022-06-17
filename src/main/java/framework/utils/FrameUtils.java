package framework.utils;

import org.openqa.selenium.By;

public final class FrameUtils extends BaseUtility {

    public static void switchToIframe(By locator) {
        log.info("switch to iframe");
        DriverUtils.getDriver().switchTo().frame(DriverUtils.getDriver().findElement(locator));
    }

    public static void backToDefaultContent() {
        log.info("switch back from iframe");
        DriverUtils.getDriver().switchTo().defaultContent();
    }

}
