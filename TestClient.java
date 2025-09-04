import java.io.*;
import java.net.*;

public class TestClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(SensorSimulator.generateSensorData());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
