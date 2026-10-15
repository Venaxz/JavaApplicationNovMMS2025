package util;
import java.io.*;
import java.nio.file.*;
public final class ObjectSerializer {
    private ObjectSerializer() {}
    public static void save(Serializable object, Path path) throws IOException {
        Files.createDirectories(path.toAbsolutePath().getParent());
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) { out.writeObject(object); }
    }
    public static Object load(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) { return in.readObject(); }
    }
}
