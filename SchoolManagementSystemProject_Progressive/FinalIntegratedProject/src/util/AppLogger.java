package util;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.*;
public final class AppLogger {
    private static final Logger LOGGER = Logger.getLogger("SchoolManagementSystem");
    static {
        try {
            Files.createDirectories(Path.of("data"));
            Handler handler = new FileHandler("data/school-management.log", true);
            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);
            LOGGER.setUseParentHandlers(true);
        } catch (IOException ex) { LOGGER.warning("Could not create file logger: " + ex.getMessage()); }
    }
    private AppLogger() {}
    public static void info(String message) { LOGGER.info(message); }
    public static void error(String message, Throwable error) { LOGGER.log(Level.SEVERE, message, error); }
}
