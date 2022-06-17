package pageobject.pages;

import pageobject.elements.TextElement;
import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.Button;
import framework.utils.Parser;

public class ProgressBarForm extends BaseForm {

    private final Button startStopButton = new Button(By.xpath("//button[@id='startStopButton']"), "Button:Start");
    private final TextElement progressBar = new TextElement(By.xpath("//div[@class='progress-bar bg-info']"), "ProgressBar");

    public ProgressBarForm() {
        super(By.xpath("//div[@id='progressBarContainer']"), "Form:ProgressBar");
    }

    public void clickOnStartStopButton() {
        startStopButton.click();
    }

    public void stopProgressOnValue(int value) {
        log.info("stopping progress on value " + value);
        progressBar.isTextToBePresentInElement(value + "%");
        startStopButton.click();
    }

    public boolean isValueMatch(int value) {
        log.info("check progress bar value matching");
        int progressBarValue = Parser.extractNumbersFromText(progressBar.getText());
        for (int i = value - 2; i < value + 3; i++) {
            if (progressBarValue == i) {
                return true;
            }
        }
        return false;
    }

}