package pageobject.elements;

import framework.pageobject.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableColumn extends BaseElement {

    public TableColumn(By locator, String name) {
        super(locator, name);
    }

    public List<String> getValuesList() {
        log.info("get table values list");
        List<String> values = new ArrayList<>();
        for (WebElement element: getElementAsElementsList()) {
            if (!element.getText().equals(" ")) {
                values.add(element.getText());
            }
        }
        return values;
    }

    public void clickOnRowN(int elementN) {
        log.info("click on element №" + elementN + " from " + getName());
        getElementAsElementsList().get(elementN).click();
    }
}
