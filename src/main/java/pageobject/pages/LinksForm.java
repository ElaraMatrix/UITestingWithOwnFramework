package pageobject.pages;

import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.Link;

public class LinksForm extends BaseForm {

    private final Link homeLink = new Link(By.xpath("//a[@id='simpleLink']"), "Link:Home");

    public LinksForm() {
        super(By.xpath("//div[@id='linkWrapper']"), "Form:Links");
    }

    public void clickOnLinkHome() {
        homeLink.click();
    }

}