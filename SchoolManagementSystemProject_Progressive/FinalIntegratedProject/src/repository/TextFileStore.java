package repository;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
public class TextFileStore {
    private final Path path;
    public TextFileStore(String fileName) {
        Path dir = Path.of("data"); this.path = dir.resolve(fileName);
        try { Files.createDirectories(dir); if (Files.notExists(path)) Files.createFile(path); }
        catch (IOException e) { throw new IllegalStateException("Cannot initialize data file: " + path, e); }
    }
    public synchronized List<String> readAll() {
        try { return Files.readAllLines(path, StandardCharsets.UTF_8); }
        catch (IOException e) { throw new IllegalStateException("Cannot read " + path, e); }
    }
    public synchronized void writeAll(List<String> lines) {
        try { Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING); }
        catch (IOException e) { throw new IllegalStateException("Cannot write " + path, e); }
    }
    public synchronized void append(String line) {
        try { Files.writeString(path, line + System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.APPEND); }
        catch (IOException e) { throw new IllegalStateException("Cannot append to " + path, e); }
    }
}
