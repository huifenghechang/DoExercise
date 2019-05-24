package A04_FactoryPattern.FactoryMethodPattern;

import A04_FactoryPattern.Pizza;

public class PatternTest {

    public static void main(String[] args){
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("Ny");
        System.out.println(pizza.toString());
        pizza = chicagoStore.orderPizza("Chicago");
        System.out.println(pizza.toString());
    }
}
