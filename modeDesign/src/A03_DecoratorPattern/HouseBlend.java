package A03_DecoratorPattern;

public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 5;
    }
}
