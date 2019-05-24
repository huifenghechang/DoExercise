package A02_ObserverPattern;

public class WeatherObserver implements Observer {
    // 观察者模式，主题与观察者是一对多的关系。因此，需要设置该变量
    Subject subject;

    // 在创建的时候，设置主题,并注册成为Observer
    public WeatherObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.printf("I am %s I am getting update !",this.toString());
        System.out.printf("temperature :%f,humidity: %f,pressure: %f\n",
                temperature,humidity,pressure);
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
