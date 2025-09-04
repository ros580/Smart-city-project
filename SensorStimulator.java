import java.util.Random;

public class SensorSimulator {
    public static String generateSensorData() {
        Random rand = new Random();
        int temperature = 20 + rand.nextInt(15);   // 20 to 34 °C
        int humidity = 30 + rand.nextInt(40);      // 30 to 70 %
        int pressure = 980 + rand.nextInt(40);     // 980 to 1020 hPa

        return temperature + "," + humidity + "," + pressure;
    }
}
