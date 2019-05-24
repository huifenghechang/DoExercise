package A02_ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject implements Subject {
    float temperature;
    float humidity;
    float pressure;
    List<Observer> observerList; // 监听者列表

    public WeatherSubject(){
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer:observerList) {
            observer.update(temperature,humidity,pressure);
        }
    }



    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
