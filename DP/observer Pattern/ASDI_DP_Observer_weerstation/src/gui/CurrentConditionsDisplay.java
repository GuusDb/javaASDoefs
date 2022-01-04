package gui;

import domain.Observer;
import domain.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private double temperature, humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    public void update(double temp, double humidity, double pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.printf("Actuele weergesteldheid %.1f graden en %.1f %% luchtvochtigheid\n",
                temperature, humidity);
    }

}
