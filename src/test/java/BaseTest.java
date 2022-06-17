import framework.utils.FileUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import framework.utils.ConfigManager;
import framework.utils.DriverUtils;
import framework.logger.LoggerUtils;

public class BaseTest {

    protected Logger log = LoggerUtils.getLogger();

    @BeforeMethod
    public void setUp() {
        FileUtils.createDownloadDirectory();
        DriverUtils.initialize(ConfigManager.getWindowWidth(),
                               ConfigManager.getWindowHeight(),
                               ConfigManager.getImplicitlyWait());
    }

    @AfterMethod
    public void tearDown() {
        FileUtils.cleanDownloadDirectory();
        DriverUtils.quit();
    }

}