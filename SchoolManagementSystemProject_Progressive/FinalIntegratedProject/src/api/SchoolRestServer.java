package api;
import com.sun.net.httpserver.HttpServer;
import service.StudentService;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
public class SchoolRestServer {
    private final StudentService service;
    private HttpServer server;
    public SchoolRestServer(StudentService service) { this.service=service; }
    public void start() throws java.io.IOException {
        if (server != null) return;
        server=HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/students", exchange -> {
            String response;
            int status=200;
            if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                response=service.getAllStudents().stream().map(s -> "{\"id\":\""+escape(s.getId())+"\",\"name\":\""+escape(s.getFullName())+"\",\"department\":\""+escape(s.getDepartment())+"\"}").toList().toString();
            } else { status=405; response="{\"error\":\"Only GET is implemented in this educational endpoint\"}"; }
            byte[] bytes=response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type","application/json; charset=UTF-8");
            exchange.sendResponseHeaders(status,bytes.length);
            try (var out=exchange.getResponseBody()) { out.write(bytes); }
        });
        server.start();
    }
    private static String escape(String value) { return value.replace("\\","\\\\").replace("\"","\\\""); }
    public void stop() { if(server!=null) server.stop(0); }
}
