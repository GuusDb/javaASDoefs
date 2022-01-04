package domain;

import java.util.HashSet;
import java.util.Set;

public class WeatherData implements Subject {

    private double temperature, humidity, pressure;

    private Set<Observer> observers;

    public WeatherData() {
        observers = new HashSet<>();
    }

    public double getHumidity() {

        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        observers.forEach(observer
                -> observer.update(temperature, humidity, pressure));
    }

}
