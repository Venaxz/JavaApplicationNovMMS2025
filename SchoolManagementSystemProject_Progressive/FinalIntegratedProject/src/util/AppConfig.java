package util;
/** Simple singleton configuration object. */
public final class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private AppConfig() {}
    public static AppConfig getInstance() { return INSTANCE; }
    public String dataDirectory() { return "data"; }
}
