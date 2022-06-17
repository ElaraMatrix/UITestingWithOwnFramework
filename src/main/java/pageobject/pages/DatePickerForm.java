package pageobject.pages;

import framework.pageobject.BaseForm;
import org.openqa.selenium.By;
import pageobject.elements.TextField;
import framework.utils.KeyboardUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerForm extends BaseForm {

    private final TextField dateInput = new TextField(By.xpath("//input[@id='datePickerMonthYearInput']"), "Input:Date");
    private final TextField timeInput = new TextField(By.xpath("//input[@id='dateAndTimePickerInput']"), "Input:Time");

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a");

    public DatePickerForm() {
        super(By.xpath("//div[@id='datePickerContainer']"), "Form:DatePicker");
    }

    public String getCurrentDate() {
        log.info("get current date");
        return LocalDateTime.now().format(dateFormatter);
    }

    public String getCurrentDateAndTime() {
        log.info("get current date and time");
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    public String getDateFromPage() {
        log.info("get date from page");
        return dateInput.getValue();
    }

    public String getDateAndTimeFromPage() {
        log.info("get date and time from page");
        return timeInput.getValue();
    }

    public String getNextDate(int month, int day) {
        log.info("get next " + day + "/" + month);
        LocalDate date = LocalDate.now();
        if (month == 2 && day == 29) {
            if (date.isLeapYear()) {
                if (date.isBefore(LocalDate.of(date.getYear(), month, day))) {
                    return LocalDate.of(date.getYear(), month, day).format(dateFormatter);
                } else {
                    return LocalDate.of(date.getYear() + 4, month, day).format(dateFormatter);
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    date = date.plusYears(1);
                    if (date.isLeapYear()) {
                        return LocalDate.of(date.getYear(), month, day).format(dateFormatter);
                    }
                }
            }
            log.error("date hasn't been found");
            return "";
        } else {
            if (date.isBefore(LocalDate.of(date.getYear(), month, day))) {
                return LocalDate.of(date.getYear(), month, day).format(dateFormatter);
            } else {
                return LocalDate.of(date.getYear() + 1, month, day).format(dateFormatter);
            }
        }
    }

    public void sendDateToInput(String date) {
        log.info("send date to " + dateInput.getName());
        dateInput.click();
        for (int i = 0; i < 10; i++) {
            KeyboardUtils.keyBackspace();
        }
        dateInput.sendText(date);
    }

}
