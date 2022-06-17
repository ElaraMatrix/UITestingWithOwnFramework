package pageobject.pages;

import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.Button;

public class LeftMenu extends BaseForm {

    private final Button elementsSubmenu = new Button(By.xpath("//div[text()='Elements' and @class='header-text']"), "Submenu:Elements");
    private final Button browserWindowsButton = new Button(By.xpath("//span[@class='text' and text()='Browser Windows']"), "Button:BrowserWindows");
    private final Button alertsButton = new Button(By.xpath("//span[@class='text' and text()='Alerts']"), "Button:Alerts");
    private final Button framesButton = new Button(By.xpath("//span[@class='text' and text()='Frames']"), "Button:Frames");
    private final Button nestedFramesButton = new Button(By.xpath("//span[@class='text' and text()='Nested Frames']"), "Button:NestedFrames");
    private final Button webTablesButton = new Button(By.xpath("//span[@class='text' and text()='Web Tables']"), "Button:WebTables");
    private final Button linksButton = new Button(By.xpath("//span[@class='text' and text()='Links']"), "Button:Links");
    private final Button sliderButton = new Button(By.xpath("//span[@class='text' and text()='Slider']"), "Button:Slider");
    private final Button progressBarButton = new Button(By.xpath("//span[@class='text' and text()='Progress Bar']"), "Button:ProgressBar");
    private final Button datePickerButton = new Button(By.xpath("//span[@class='text' and text()='Date Picker']"), "Button:DatePicker");
    private final Button uploadAndDownload = new Button(By.xpath("//span[@class='text' and text()='Upload and Download']"), "Button:UploadAndDownload");

    public LeftMenu() {
        super(By.xpath("//div[@class='main-header' and contains(text(), 'Alerts')]"), "LeftMenu");
    }

    public void clickOnElementsSubmenu() {
        elementsSubmenu.click();
    }

    public void clickOnAlertsButton() {
        alertsButton.click();
    }

    public void clickOnNestedFramesButton() {
        nestedFramesButton.click();
    }

    public void clickOnFramesButton() {
        framesButton.click();
    }

    public void clickOnBrowserWindowsButton() {
        browserWindowsButton.click();
    }

    public void clickOnWebTablesButton() {
        webTablesButton.click();
    }

    public void clickOnLinksButton() {
        linksButton.click();
    }

    public void clickOnSliderButton() {
        sliderButton.click();
    }

    public void clickOnProgressBarButton() {
        progressBarButton.click();
    }

    public void clickOnDatePickerButton() {
        datePickerButton.click();
    }

    public void clickOnUploadAndDownloadButton() {
        uploadAndDownload.click();
    }

}