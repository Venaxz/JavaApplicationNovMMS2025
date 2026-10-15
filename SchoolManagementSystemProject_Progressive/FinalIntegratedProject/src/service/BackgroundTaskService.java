package service;
import java.util.concurrent.*;
public class BackgroundTaskService implements AutoCloseable {
    private final ExecutorService pool = Executors.newFixedThreadPool(2);
    public Future<?> runReport(Runnable task) { return pool.submit(task); }
    @Override public void close() { pool.shutdown(); }
}
