import java.io.*;
import java.net.*;
import java.sql.*;

public class WeatherReceiver {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Weather server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String data = in.readLine();

                if (data != null) {
                    String[] parts = data.split(",");
                    int temperature = Integer.parseInt(parts[0]);
                    int humidity = Integer.parseInt(parts[1]);
                    int pressure = Integer.parseInt(parts[2]);

                    System.out.println("Received: Temp=" + temperature + "C, Humidity=" + humidity + "%, Pressure=" + pressure + " hPa");
                    saveToDatabase(temperature, humidity, pressure);
                }
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToDatabase(int temp, int humidity, int pressure) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weatherdb", "root", "password");
            String sql = "INSERT INTO readings (temperature, humidity, pressure, timestamp) VALUES (?, ?, ?, NOW())";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, temp);
            stmt.setInt(2, humidity);
            stmt.setInt(3, pressure);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
