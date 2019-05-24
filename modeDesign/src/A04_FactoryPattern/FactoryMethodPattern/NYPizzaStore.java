package A04_FactoryPattern.FactoryMethodPattern;

import A04_FactoryPattern.ChessPizza;
import A04_FactoryPattern.FactoryMethodPattern.PizzaStore;
import A04_FactoryPattern.MilkPizza;
import A04_FactoryPattern.NySpecialPizza;
import A04_FactoryPattern.Pizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("Ny")){
            return new NySpecialPizza();
        }else if (type.equals("Milk")){
            return new MilkPizza();
        }
        return null;
    }
}
