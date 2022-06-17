import models.User;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.pages.*;

public class MainTest extends BaseTest {

    private final String mainURL = ConfigManager.getURL();

    private final HomePage homePage = new HomePage();
    private final LeftMenu leftMenu = new LeftMenu();
    private final SamplePage samplePage = new SamplePage();
    private final BrowserWindowsForm browserWindowsForm = new BrowserWindowsForm();
    private final AlertsForm alertsForm = new AlertsForm();
    private final NestedFramesForm nestedFramesForm = new NestedFramesForm();
    private final FramesForm framesForm = new FramesForm();
    private final WebTablesForm webTablesForm = new WebTablesForm();
    private final LinksForm linksForm = new LinksForm();
    private final RegistrationForm registrationForm = new RegistrationForm();
    private final SliderForm sliderForm = new SliderForm();
    private final ProgressBarForm progressBarForm = new ProgressBarForm();
    private final DatePickerForm datePickerForm = new DatePickerForm();
    private final DownloadForm downloadForm = new DownloadForm();

    @Test
    public void testCase1() {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnAlertsButton();
        leftMenu.clickOnAlertsButton();
        Assert.assertTrue(alertsForm.isOpened(), AssertMessages.notLoaded(alertsForm.getName()));

        alertsForm.clickOnToSeeAlertButton();
        Assert.assertEquals(alertsForm.getAlertText(), "You clicked a button", AssertMessages.notOpened("Alert"));

        alertsForm.acceptOpenedAlert();
        Assert.assertFalse(alertsForm.isThereAlertOnPage(), AssertMessages.notClosed("Alert"));

        alertsForm.clickOnConfirmButton();
        Assert.assertEquals(alertsForm.getAlertText(), "Do you confirm action?", AssertMessages.notOpened("Confirm"));

        alertsForm.acceptOpenedAlert();
        Assert.assertFalse(alertsForm.isThereAlertOnPage(), AssertMessages.notClosed("Confirm"));
        Assert.assertTrue(alertsForm.isAppearConfirmResult("You selected Ok"), "Confirm result does not match");

        alertsForm.clickOnPromptButton();
        Assert.assertEquals(alertsForm.getAlertText(), "Please enter your name", AssertMessages.notOpened("Prompt"));

        String randomWord = RandomGenerator.getRandomWord();
        alertsForm.sendKeysAndAcceptPrompt(randomWord);
        Assert.assertFalse(alertsForm.isThereAlertOnPage(), AssertMessages.notClosed("Prompt"));
        Assert.assertTrue(alertsForm.isAppearPromptResult(randomWord), AssertMessages.notMatch("PromptResult"));
    }

    @Test
    public void testCase2() {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnAlertsButton();
        leftMenu.clickOnNestedFramesButton();
        Assert.assertTrue(nestedFramesForm.isOpened(), AssertMessages.notLoaded(nestedFramesForm.getName()));

        nestedFramesForm.switchToParentIframe();
        Assert.assertEquals("Parent frame", nestedFramesForm.getTextFromParentIframe(), AssertMessages.notMatch("ParentFrame"));
        nestedFramesForm.switchToChildIframe();
        Assert.assertEquals("Child Iframe", nestedFramesForm.getTextFromChildIframe(), AssertMessages.notMatch("ChildFrame"));
        nestedFramesForm.backToDefaultContent();

        leftMenu.clickOnFramesButton();
        Assert.assertTrue(framesForm.isOpened(), AssertMessages.notLoaded(framesForm.getName()));
        String topIframeText = framesForm.getTextFromTopIframe();
        String bottomIframeText = framesForm.getTextFromBottomIframe();
        Assert.assertEquals(topIframeText, bottomIframeText, AssertMessages.notEquals(topIframeText, bottomIframeText));
    }

    @Test(dataProvider = "getUsersData", dataProviderClass = TestData.class)
    public void testCase3(User user) {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnElementsButton();
        leftMenu.clickOnWebTablesButton();
        Assert.assertTrue(webTablesForm.isOpened(), AssertMessages.notLoaded(webTablesForm.getName()));

        webTablesForm.clickOnAddButton();
        Assert.assertTrue(registrationForm.isOpened(), AssertMessages.notLoaded(registrationForm.getName()));

        registrationForm.enterUserData(user);
        registrationForm.clickOnSubmit();
        Assert.assertFalse(registrationForm.isOpened(), AssertMessages.notClosed(registrationForm.getName()));
        Assert.assertTrue(webTablesForm.isUserPresent(user), "The user is not present on the list");

        int tableSizeBeforeDeleting = webTablesForm.getEmailsFromList().size();
        webTablesForm.deleteRecordFromList(user);
        int tableSizeAfterDeleting = webTablesForm.getEmailsFromList().size();
        Assert.assertNotEquals(tableSizeBeforeDeleting, tableSizeAfterDeleting, AssertMessages.notChanged("Records"));
        Assert.assertFalse(webTablesForm.isUserPresent(user), "This user is still on the list");
    }

    @Test
    public void testCase4() {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnAlertsButton();
        leftMenu.clickOnBrowserWindowsButton();
        Assert.assertTrue(browserWindowsForm.isOpened(), AssertMessages.notLoaded(browserWindowsForm.getName()));

        browserWindowsForm.clickOnNewTabButton();
        WindowUtils.switchToWindow(2);
        Assert.assertTrue(samplePage.isThisSamplePage(), AssertMessages.notLoaded(samplePage.getName()));

        WindowUtils.closeCurrentWindow();
        Assert.assertTrue(browserWindowsForm.isOpened(), AssertMessages.notLoaded(browserWindowsForm.getName()));

        leftMenu.clickOnElementsSubmenu();
        leftMenu.clickOnLinksButton();
        Assert.assertTrue(linksForm.isOpened(), AssertMessages.notLoaded(linksForm.getName()));

        linksForm.clickOnLinkHome();
        WindowUtils.switchToAnotherWindow();
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        WindowUtils.switchToAnotherWindow();
        Assert.assertTrue(linksForm.isOpened(), AssertMessages.notLoaded(linksForm.getName()));
    }

    @Test
    public void testCase5() {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnWidgetsButton();
        leftMenu.clickOnSliderButton();
        Assert.assertTrue(sliderForm.isOpened(), AssertMessages.notLoaded(sliderForm.getName()));

        int sliderValue = RandomGenerator.getRandomNumber(0, 100);
        sliderForm.setValueToSlider(sliderValue);
        int sliderValueFromLabel = sliderForm.getValue();
        Assert.assertEquals(sliderValue, sliderValueFromLabel, AssertMessages.notEquals(sliderValue, sliderValueFromLabel));

        leftMenu.clickOnProgressBarButton();
        Assert.assertTrue(progressBarForm.isOpened(), AssertMessages.notLoaded(progressBarForm.getName()));

        progressBarForm.clickOnStartStopButton();
        int age = ConfigManager.getAuthorAge();
        progressBarForm.stopProgressOnValue(age);
        Assert.assertTrue(progressBarForm.isValueMatch(age), AssertMessages.notMatch("progress bar value"));
    }

    @Test
    public void testCase6() {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnWidgetsButton();
        leftMenu.clickOnDatePickerButton();
        Assert.assertTrue(datePickerForm.isOpened(), AssertMessages.notLoaded(datePickerForm.getName()));

        String dateFromPage = datePickerForm.getDateFromPage();
        String dateAndTimeFromPage = datePickerForm.getDateAndTimeFromPage();
        String currentDate = datePickerForm.getCurrentDate();
        String currentDateAndTime = datePickerForm.getCurrentDateAndTime();
        Assert.assertEquals(dateFromPage, currentDate, AssertMessages.notMatch("Date"));
        Assert.assertEquals(dateAndTimeFromPage, currentDateAndTime, AssertMessages.notMatch("Date and Time"));

        String next29Feb = datePickerForm.getNextDate(2, 29);
        datePickerForm.sendDateToInput(next29Feb);
        dateFromPage = datePickerForm.getDateFromPage();
        Assert.assertEquals(next29Feb, dateFromPage, AssertMessages.notMatch("Date"));
    }

    @Test
    public void testCase7() {
        DriverUtils.loadURL(mainURL);
        Assert.assertTrue(homePage.isOpened(), AssertMessages.notLoaded(homePage.getName()));

        homePage.clickOnElementsButton();
        leftMenu.clickOnUploadAndDownloadButton();
        Assert.assertTrue(downloadForm.isOpened(), AssertMessages.notLoaded(downloadForm.getName()));

        downloadForm.clickOnDownloadButton();
        downloadForm.waitForDownload();
        Assert.assertTrue(FileUtils.isFileDownloaded("sampleFile.jpeg"), "File is not found");

        downloadForm.uploadFile();
        downloadForm.waitForDownload();
        Assert.assertTrue(downloadForm.isFileUploaded(), "File is not uploaded");
    }

}