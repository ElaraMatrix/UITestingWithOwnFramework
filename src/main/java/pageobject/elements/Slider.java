package pageobject.elements;

import framework.pageobject.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import framework.utils.DriverUtils;

public class Slider extends BaseElement {

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void clickAndHold() {
        log.info("Slider holding");
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.clickAndHold(getElementAsWebElement()).perform();
    }

    public void release() {
        log.info("Slider release");
        Actions actions = new Actions(DriverUtils.getDriver());
        actions.release(getElementAsWebElement()).perform();
    }

}