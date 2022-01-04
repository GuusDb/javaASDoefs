package gui;

import domain.Observer;
import domain.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {

    private double maxTemp = 0.0f;
    private double minTemp = 200;
    private double tempSum = 0.0f;
    private int numReadings;
    private Subject subject;

    public StatisticsDisplay(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    public void update(double temp, double humidity, double pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override
    public void display() {
        System.out.printf("Gem/Max/Min temperature = %.1f/%.1f/%.1f\n",
                (tempSum / numReadings), maxTemp, minTemp);
    }

}
