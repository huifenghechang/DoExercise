package A04_FactoryPattern.FactoryPattern;

import A04_FactoryPattern.Pizza;

public class MyChessPizza extends Pizza {
    PizzaIngredientFactory factory;

    public MyChessPizza(PizzaIngredientFactory factory){
        this.factory = factory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = factory.createDough();
        sauce = factory.createSauce();
    }
}
