package domain;

public interface Subject {

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);
}
