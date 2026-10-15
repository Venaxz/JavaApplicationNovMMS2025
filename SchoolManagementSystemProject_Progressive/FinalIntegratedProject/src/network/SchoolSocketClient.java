package network;
import java.net.Socket;
import java.io.*;
import java.nio.charset.StandardCharsets;
public final class SchoolSocketClient {
    private SchoolSocketClient() {}
    public static String request(String host,int port,String message) throws IOException {
        try(Socket socket=new Socket(host,port);
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8));
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8))) {
            out.write(message); out.newLine(); out.flush(); return in.readLine();
        }
    }
}
