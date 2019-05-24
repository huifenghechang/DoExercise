package A01_StrategyPattern;

public class DemoTest {
    public static void main(String[] args){
        MallardDuck duck = new MallardDuck();
        FlyWithPlane flyWithPlane = new FlyWithPlane();

        duck.setFlyBehavior(flyWithPlane);
        duck.performFly();
        duck.performQuack();
    }
}
