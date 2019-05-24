package A03_DecoratorPattern;

public class MochaDecorator extends CondimentDecorator {
    Beverage beverage;

    // 装饰者，通过构造函数来传入
    public MochaDecorator(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return "Mocha" + beverage.getDescription();
    }

    @Override
    public double cost() {
        return 0.5 + beverage.cost();
    }
}
