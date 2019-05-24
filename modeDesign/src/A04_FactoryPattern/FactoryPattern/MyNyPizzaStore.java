package A04_FactoryPattern.FactoryPattern;

import A04_FactoryPattern.FactoryMethodPattern.PizzaStore;
import A04_FactoryPattern.Pizza;

public class MyNyPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory nyfactory = new NyPizzaIngredientFactory();
        
        if (type.equals("Ny")){
            pizza = new MyChessPizza(nyfactory);
        }

        return pizza;
    }
}
