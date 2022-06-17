import models.User;
import framework.logger.LoggerUtils;
import framework.utils.ConfigManager;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "getUsersData")
    public static Object[][] getUsersData() {
        LoggerUtils.getLogger().info("get all users from config");
        int countUsers = 0;
        while (true) {
            try {
                ConfigManager.getUser(countUsers + 1);
                countUsers++;
            } catch (NullPointerException e) {
                break;
            }
        }
        User[][] users = new User[countUsers][1];
        for (int i = 0; i < countUsers; i++) {
            users[i][0] = ConfigManager.getUser(i + 1);
        }
        return users;
    }

}