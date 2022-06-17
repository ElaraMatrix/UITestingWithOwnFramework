package framework.utils;

public final class Parser extends BaseUtility {

    private Parser() {}

    public static int extractNumbersFromText(String text) {
        log.info("extracting numbers from text: " + text);
        String replaced = text.replaceAll("[^0-9]", "");
        return Integer.parseInt(replaced);
    }

}