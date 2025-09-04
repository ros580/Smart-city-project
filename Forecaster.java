public class Forecaster {
    public static String forecastWeather(int temperature, int humidity, int pressure) {
        if (pressure < 1000 && humidity > 60)
            return "Rain likely";
        else if (temperature > 30)
            return "Hot and sunny";
        else
            return "Moderate weather";
    }
}
