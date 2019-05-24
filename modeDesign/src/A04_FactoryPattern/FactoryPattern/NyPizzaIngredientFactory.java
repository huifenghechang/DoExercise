package A04_FactoryPattern.FactoryPattern;

import java.util.List;

public class NyPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public String createDough() {
        return "NY Dough";
    }

    @Override
    public String createSauce() {
        return "NY Sauce";
    }

    @Override
    public String createCheese() {
        return "NY Cheese";
    }

    @Override
    public String[] createVeges() {
        String[] veges = {"Apple","Banana","Orange","Turkey"};
        return veges;
    }
}
