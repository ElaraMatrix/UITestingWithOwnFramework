package pageobject.elements;

import framework.pageobject.BaseElement;
import org.openqa.selenium.By;

public class Input extends BaseElement {

    public Input(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String text) {
        log.info(getName() + " sending: " + text);
        getElementAsWebElement().sendKeys(text);
    }
}