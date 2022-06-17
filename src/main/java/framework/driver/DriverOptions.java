package framework.driver;

import framework.utils.ConfigManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Hashtable;
import java.util.Map;

class DriverOptions {

    private DriverOptions() {}

    static ChromeOptions getChromeOptions() {
        Map<String, Object> preferences = new Hashtable<>();
        preferences.put("download.default_directory", ConfigManager.getDownloadPath());

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", preferences);

        return options;
    }

}
