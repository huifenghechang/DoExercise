package A04_FactoryPattern.FactoryMethodPattern;

import A04_FactoryPattern.ChessPizza;
import A04_FactoryPattern.ChicagoSpecialPizza;
import A04_FactoryPattern.MilkPizza;
import A04_FactoryPattern.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("Chicago")){
            return new ChicagoSpecialPizza();
        }else if (type.equals("Milk")){
            return new MilkPizza();
        }
        return null;
    }
}
