package A04_FactoryPattern.FactoryPattern;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public String createDough() {
        return "Chicago Dough";
    }

    @Override
    public String createSauce() {
        return "Chicago Sauce";
    }

    @Override
    public String createCheese() {
        return "Chicago Cheese";
    }

    @Override
    public String[] createVeges() {
        String[] veges = {"Chicago Apple","Banana","Orange","Turkey"};
        return veges;
    }
}
