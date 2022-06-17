package pageobject.pages;

import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.Button;

public class BrowserWindowsForm extends BaseForm {

    private final Button newTabButton = new Button(By.xpath("//button[@id='tabButton']"), "Button:NewTab");

    public BrowserWindowsForm() {
        super(By.xpath("//div[@id='browserWindows']"), "Form:BrowserWindows");
    }

    public void clickOnNewTabButton() {
        newTabButton.click();
    }

}