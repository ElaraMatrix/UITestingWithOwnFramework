package pageobject.pages;

import pageobject.elements.TextElement;
import framework.pageobject.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {

    private final TextElement pageTitle = new TextElement(By.xpath("//h1[@id='sampleHeading']"), "SamplePageTitle");

    public SamplePage() {
        super(By.xpath("//h1[@id='sampleHeading']"), "SamplePage");
    }

    public boolean isThisSamplePage() {
        log.info("sample page checking");
        return pageTitle.isTextToBePresentInElement("sample page") && this.isUrlContains("/sample");
    }

}