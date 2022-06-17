package framework.utils;

public final class AssertMessages {

    private AssertMessages() {}

    private final static String NOT_LOADED = " has not been loaded";
    private final static String NOT_OPENED = " has not been opened";
    private final static String NOT_CLOSED = " has not been closed";
    private final static String NOT_CHANGED = " has not been changed";
    private final static String NOT_MATCH = " does not match";
    private final static String NOT_EQUALS = " are not equals";

    public static String notLoaded(String elementName) {
        return elementName + NOT_LOADED;
    }

    public static String notOpened(String elementName) {
        return elementName + NOT_OPENED;
    }

    public static String notClosed(String elementName) {
        return elementName + NOT_CLOSED;
    }

    public static String notChanged(String elementName) {
        return elementName + NOT_CHANGED;
    }

    public static String notMatch(String elementName) {
        return elementName + NOT_MATCH;
    }

    public static String notEquals(String element1Name, String element2Name) {
        return element1Name + " and " + element2Name + NOT_EQUALS;
    }

    public static String notEquals(int value1, int value2) {
        return value1 + " and " + value2 + NOT_EQUALS;
    }

}