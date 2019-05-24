package A01_StrategyPattern;

public class FlyWithPlane implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am fly with planes");
    }
}
