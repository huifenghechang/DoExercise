package A03_DecoratorPattern;

public abstract class Beverage {
    protected String description = "UnKnow Beverage";
    String getDescription(){
        return description;
    };
    public abstract double cost();
}
