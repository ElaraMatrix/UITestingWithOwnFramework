package pageobject.pages;

import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.Slider;
import pageobject.elements.TextField;
import framework.utils.KeyboardUtils;

public class SliderForm extends BaseForm {

    private final TextField sliderValue = new TextField(By.xpath("//input[@id='sliderValue']"), "Input:SliderValue");
    private final Slider slider = new Slider(By.xpath("//input[@class='range-slider range-slider--primary']"), "Slider");

    public SliderForm() {
        super(By.xpath("//div[@id='sliderContainer']"), "Form:Slider");
    }

    public void setValueToSlider(int value) {
        log.info("setting the value: " + value + " to slider ");
        slider.clickAndHold();
        if (value < getValue()) {
            while (value != getValue()) {
                KeyboardUtils.keyArrowLeft();
            }
        } else {
            while (value != getValue()) {
                KeyboardUtils.keyArrowRight();
            }
        }
        slider.release();
    }

    public int getValue() {
        log.info("get slider value from label");
        return Integer.parseInt(sliderValue.getValue());
    }

}