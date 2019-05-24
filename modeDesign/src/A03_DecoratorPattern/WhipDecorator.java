package A03_DecoratorPattern;

public class WhipDecorator extends CondimentDecorator {
    Beverage beverage;

    public WhipDecorator(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return "Whip"+beverage.getDescription();
    }

    @Override
    public double cost() {
        return 0.7 + beverage.cost();
    }
}
