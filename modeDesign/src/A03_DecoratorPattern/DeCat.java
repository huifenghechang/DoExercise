package A03_DecoratorPattern;

public class DeCat  extends Beverage{

    public DeCat(){
        description = "DeCat";
    }
    @Override
    public double cost() {
        return 2;
    }
}
