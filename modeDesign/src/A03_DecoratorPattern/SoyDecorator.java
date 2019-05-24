package A03_DecoratorPattern;

public class SoyDecorator extends CondimentDecorator {
    Beverage beverage;

    public SoyDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Soy" + beverage.getDescription();
    }

    @Override
    public double cost() {
        return 0.6 + beverage.cost();
    }
}
