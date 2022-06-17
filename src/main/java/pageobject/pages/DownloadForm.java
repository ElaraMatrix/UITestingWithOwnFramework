package pageobject.pages;

import pageobject.elements.Input;
import pageobject.elements.TextElement;
import framework.pageobject.BaseForm;
import framework.utils.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.elements.Button;
import framework.utils.WaitDriverUtils;

public class DownloadForm extends BaseForm {

    private final Button downloadButton = new Button(By.xpath("//a[@id='downloadButton']"), "Button:Download");
    private final Input uploadInput = new Input(By.xpath("//input[@id='uploadFile']"), "Button:Upload");
    private final TextElement uploadedFilePath = new TextElement(By.xpath("//p[@id='uploadedFilePath']"), "UploadedFilePath");
    private final String downloadedFileName = ConfigManager.getDownloadFileName();

    public DownloadForm() {
        super(By.xpath("//a[@id='downloadButton']"), "Form:Download/Upload");
    }

    public void clickOnDownloadButton() {
        downloadButton.click();
    }

    public void waitForDownload() {
        log.info("download/upload waiting");
        try {
            WaitDriverUtils.getDriverWait().until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public boolean isFileUploaded() {
        log.info(" is file uploaded check");
        return uploadedFilePath.isTextToBePresentInElement(downloadedFileName);
    }

    public void uploadFile() {
        log.info("file uploading");
        uploadInput.sendKeys(ConfigManager.getDownloadPath() + downloadedFileName);
    }

}