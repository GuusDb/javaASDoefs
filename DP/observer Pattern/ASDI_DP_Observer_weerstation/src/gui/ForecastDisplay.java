package gui;

import domain.Observer;
import domain.Subject;

public class ForecastDisplay implements Observer, DisplayElement {

    private double currentPressure = 29.92f;
    private double lastPressure;
    private Subject subject;

    public ForecastDisplay(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    public void update(double temp, double humidity, double pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

    public void display() {
        System.out.print("Weersverwachting: ");
        if (currentPressure > lastPressure) {
            System.out.println("Beter weer op komst!");
        } else if (currentPressure == lastPressure) {
            System.out.println("Meer van hetzelfde");
        } else if (currentPressure < lastPressure) {
            System.out.println("Koeler, regenachtig weer op komst");
        }
    }
}
