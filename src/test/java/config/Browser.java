package config;
/**
 * Enumeration to represent the browser to be used for execution
 *
 * @author Chindhu Babu
 */
public enum Browser {
    CHROME("chrome"), FIREFOX("firefox"), CHROME_HEADLESS("chrome_headless"), EDGE("edge"), INTERNET_EXPLORER("internet explorer");

    private String value;

    Browser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
