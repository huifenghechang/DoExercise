package A02_ObserverPattern;

public interface Subject {
     void registerObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifyAllObserver();
}
