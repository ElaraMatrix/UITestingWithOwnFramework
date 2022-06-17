package pageobject.pages;

import framework.pageobject.BaseForm;
import models.User;
import org.openqa.selenium.By;
import pageobject.elements.Button;
import pageobject.elements.TextField;

public class RegistrationForm extends BaseForm {

    private final TextField firstName = new TextField(By.xpath("//div[@id='firstName-wrapper']//input"), "Input:FirstName");
    private final TextField lastName = new TextField(By.xpath("//div[@id='lastName-wrapper']//input"), "Input:LastName");
    private final TextField email = new TextField(By.xpath("//div[@id='userEmail-wrapper']//input"), "Input:Email");
    private final TextField age = new TextField(By.xpath("//div[@id='age-wrapper']//input"), "Input:Age");
    private final TextField salary = new TextField(By.xpath("//div[@id='salary-wrapper']//input"), "Input:Salary");
    private final TextField department = new TextField(By.xpath("//div[@id='department-wrapper']//input"), "Input:Department");
    private final Button submit = new Button(By.xpath("//button[@id='submit']"), "Button:Submit");

    public RegistrationForm() {
        super(By.xpath("//form[@id='userForm']"), "RegistrationForm");
    }

    public void enterUserData(User user) {
        firstName.sendText(user.getFirstName());
        lastName.sendText(user.getLastName());
        email.sendText(user.getEmail());
        age.sendText(user.getAge() + "");
        salary.sendText(user.getSalary() + "");
        department.sendText(user.getDepartment());
    }

    public void clickOnSubmit() {
        submit.click();
    }

}