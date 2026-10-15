package network;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class SchoolSocketServer {
    private final int port;
    public SchoolSocketServer(int port) { this.port=port; }
    public void startOnce() throws IOException {
        try (ServerSocket server=new ServerSocket(port); Socket socket=server.accept();
             BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
             BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8))) {
            String request=in.readLine();
            out.write("School server received: " + request); out.newLine(); out.flush();
        }
    }
}
