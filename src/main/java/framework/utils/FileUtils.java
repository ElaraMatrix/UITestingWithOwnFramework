package framework.utils;

import java.io.File;

public final class FileUtils extends BaseUtility {

    private FileUtils() {}

    public static boolean isFileDownloaded(String fileName) {
        log.info("download checking");
        return new File(ConfigManager.getDownloadPath() + fileName).exists();
    }

    public static void createDownloadDirectory() {
        log.info("download directory creation");
        File downloadDir = new File(ConfigManager.getDownloadPath());
        if (!downloadDir.exists()) {
            if (downloadDir.mkdir()) log.info(downloadDir.getName() + " has been created");
        }
    }

    public static void cleanDownloadDirectory() {
        log.info("download directory deleting");
        File[] downloadDirFiles = new File(ConfigManager.getDownloadPath()).listFiles();
        assert downloadDirFiles != null;
        for (File file: downloadDirFiles) {
            if (file.delete()) { log.info(file.getName() + "has been deleted"); }
            else { log.warn(file.getName() + "hasn't been deleted"); }
        }
    }

}
