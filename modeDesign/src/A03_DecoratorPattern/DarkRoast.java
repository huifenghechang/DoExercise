package A03_DecoratorPattern;

public class DarkRoast extends Beverage {

    public DarkRoast(){
        description = "DarkRoast";
    }
    @Override
    public double cost() {
        return 1.0;
    }
}
