package framework.pageobject;

import framework.logger.LoggerUtils;
import framework.utils.ConfigManager;
import framework.utils.WaitDriverUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import framework.utils.DriverUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class BaseElement {

    private final By locator;
    private final String name;
    protected static Logger log = LoggerUtils.getLogger();

    protected BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    protected WebElement getElementAsWebElement() {
        return DriverUtils.getDriver().findElement(locator);
    }

    protected List<WebElement> getElementAsElementsList() {
        return DriverUtils.getDriver().findElements(locator);
    }

    public boolean isExist() {
        log.info("is element exist checking");
        List<WebElement> list = DriverUtils.getDriver().findElements(locator);
        return list.size() > 0;
    }

    public void click() {
        log.info("click on " + getName());
        try {
            getElementAsWebElement().click();
        } catch (ElementClickInterceptedException e){
            log.warn("using JavaScriptExecutor for click because default click returned ElementClickInterceptedException");
            JavascriptExecutor executor = (JavascriptExecutor) DriverUtils.getDriver();
            executor.executeScript("arguments[0].click();", getElementAsWebElement());
        }
    }

    public boolean isTextToBePresentInElement(String text) {
        log.info("check text in element");
        DriverUtils.setImplicitlyWait(0);
        boolean result = WaitDriverUtils.getFluentWait().until(ExpectedConditions
                .textToBePresentInElement(getElementAsWebElement(), text));
        DriverUtils.setImplicitlyWait(ConfigManager.getImplicitlyWait());
        return result;
    }

}