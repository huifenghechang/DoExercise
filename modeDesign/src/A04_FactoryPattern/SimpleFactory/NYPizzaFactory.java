package A04_FactoryPattern.SimpleFactory;

import A04_FactoryPattern.ChessPizza;
import A04_FactoryPattern.NySpecialPizza;
import A04_FactoryPattern.Pizza;

public class NYPizzaFactory extends SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("ny")){
            pizza = new NySpecialPizza();
        }
        return pizza;
    }
}
