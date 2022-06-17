package framework.utils;

import java.util.ArrayList;

public final class WindowUtils extends BaseUtility {

    private WindowUtils() {}

    //this example was shown in Selenium Documentation. It works correctly only when we have two tabs
    public static void switchToAnotherWindow() {
        log.info("switching to another window");
        String originalWindow = DriverUtils.getDriver().getWindowHandle();
        for (String windowHandle : DriverUtils.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriverUtils.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void switchToAnotherWindow(String currentWindowHandle) {
        log.info("switching to another window");
        for (String windowHandle : DriverUtils.getDriver().getWindowHandles()) {
            if (!currentWindowHandle.contentEquals(windowHandle)) {
                DriverUtils.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void switchToWindow(int windowNumber) {
        log.info("switching to window " + windowNumber);
        ArrayList<String> tabs = new ArrayList<> (DriverUtils.getDriver().getWindowHandles());
        DriverUtils.getDriver().switchTo().window(tabs.get(windowNumber - 1));
    }

    public static void closeCurrentWindow() {
        log.info("closing current window");
        String originalWindow = DriverUtils.getDriver().getWindowHandle();
        DriverUtils.close();
        switchToAnotherWindow(originalWindow);
    }

}