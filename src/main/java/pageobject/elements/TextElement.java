package pageobject.elements;

import framework.pageobject.BaseElement;
import org.openqa.selenium.By;

public class TextElement extends BaseElement {

    public TextElement(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        log.info("get text from " + getName());
        return getElementAsWebElement().getText();
    }

}
