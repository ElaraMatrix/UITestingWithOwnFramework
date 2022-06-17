package pageobject.pages;

import framework.pageobject.BaseForm;
import models.User;
import framework.utils.DriverUtils;
import org.openqa.selenium.By;
import pageobject.elements.Button;
import pageobject.elements.TableColumn;
import java.util.List;

public class WebTablesForm extends BaseForm {

    private final Button addButton = new Button(By.xpath("//button[@id='addNewRecordButton']"), "Button:addNewRecord");
    private final TableColumn emailColumn = new TableColumn(By.xpath("//div[@class='rt-tr-group']/div/div[4]"), "EmailColumn");
    private final TableColumn deleteColumn = new TableColumn(By.xpath("//span[contains(@id, 'delete-record')]"), "DeleteColumn");

    public WebTablesForm() {
        super(By.xpath("//div[@class='web-tables-wrapper']"), "Form:WebTables");
    }

    public void clickOnAddButton() {
        addButton.click();
    }

    public List<String> getEmailsFromList() {
        return emailColumn.getValuesList();
    }

    public boolean isUserPresent(User user) {
        log.info("checking if user is in the list");
        List<String> emailList = getEmailsFromList();
        for (String s: emailList) {
            if (s.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void deleteRecordFromList(User user) {
        log.info("delete " + user.getFirstName() + " " + user.getLastName());
        List<String> emailList = getEmailsFromList();
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).equals(user.getEmail())) {
                deleteColumn.clickOnRowN(i);
            }
        }
    }

}