package pageobject.pages;

import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.Button;

public class HomePage extends BaseForm {

    private final Button elementsButton = new Button(By.xpath("//div[@class='card-body']/*[contains(text(), 'Elements')]"), "Button:Elements");
    private final Button alertsButton = new Button(By.xpath("//div[@class='card-body']/*[contains(text(), 'Alerts')]"), "Button:Alerts");
    private final Button widgetsButton = new Button(By.xpath("//div[@class='card-body']/*[contains(text(), 'Widgets')]"), "Button:Widgets");

    public HomePage() {
        super(By.xpath("//div[@class='home-content']"), "HomePage");
    }

    public void clickOnAlertsButton() {
        alertsButton.click();
    }

    public void clickOnElementsButton() {
        elementsButton.click();
    }

    public void clickOnWidgetsButton() {
        widgetsButton.click();
    }

}