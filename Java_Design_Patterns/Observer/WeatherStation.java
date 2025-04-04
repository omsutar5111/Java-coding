package Java_Design_Patterns.Observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherReport weatherReport = new WeatherReport();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherReport);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherReport);
        weatherReport.setMeasurements(41f, 65f, 110f);
        weatherReport.setMeasurements(28.0f, 70.0f, 1005.0f);
        weatherReport.setMeasurements(48.0f, 50.0f, 1010.0f);

    }
}
