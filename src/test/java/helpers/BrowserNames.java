package helpers;

public enum BrowserNames {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String stringValue;
    BrowserNames(final String s) { stringValue = s; }

    public final String toString() { return stringValue; }
}
