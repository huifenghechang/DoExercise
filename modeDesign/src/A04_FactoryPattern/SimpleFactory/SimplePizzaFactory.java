package A04_FactoryPattern.SimpleFactory;

import A04_FactoryPattern.ChessPizza;
import A04_FactoryPattern.Pizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("Chess")){
            pizza = new ChessPizza();
        }
        return pizza;
    }
}
