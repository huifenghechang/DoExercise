package A01_StrategyPattern;

public class SQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squack");
    }
}
