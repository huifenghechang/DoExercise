package A02_ObserverPattern;

public class DemoObserverTest {

    public static void main(String[] args){
        WeatherSubject weatherSubject = new WeatherSubject();
        WeatherObserver Observer1 = new WeatherObserver(weatherSubject);
        WeatherObserver Observer2 = new WeatherObserver(weatherSubject);

        weatherSubject.setHumidity(111);
        weatherSubject.setTemperature(22);
        weatherSubject.setPressure(333);
        weatherSubject.notifyAllObserver();
    }

}
