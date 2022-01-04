
import gui.CurrentConditionsDisplay;
import gui.ForecastDisplay;
import gui.StatisticsDisplay;
import domain.WeatherData;

public class WeatherStation {

    public WeatherStation() {
        System.out.println("Weerstation");

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay
                = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
