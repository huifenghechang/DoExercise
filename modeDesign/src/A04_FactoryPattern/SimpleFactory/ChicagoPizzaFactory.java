package A04_FactoryPattern.SimpleFactory;

import A04_FactoryPattern.ChessPizza;
import A04_FactoryPattern.ChicagoSpecialPizza;
import A04_FactoryPattern.Pizza;

public class ChicagoPizzaFactory extends SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equals("chicago")){
            pizza = new ChicagoSpecialPizza();
        }
        return pizza;
    }
}
