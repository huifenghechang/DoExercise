package A04_FactoryPattern.SimpleFactory;

import A04_FactoryPattern.Pizza;

public class SimpleFactoryDemoTest {

    public static void main(String[] args){
        SimplePizzaFactory factory = new SimplePizzaFactory();
        // 使用简单工厂，来提供Pizza
        PizzaStore pizzaStore = new PizzaStore(factory);
        Pizza pizza = pizzaStore.orderPizza("Chess");
        System.out.println("Pizza is provided!" + pizza.toString());


        /*
        * 使用简单工厂方法，无法将加盟动作和创建披萨捆绑在一起！！！
        * 为什么要捆绑在一起呢？
        * 因为要防止其修改披萨的生产流程！！！
        * */
        NYPizzaFactory nyPizzaFactory = new NYPizzaFactory();
        PizzaStore nyPizzaStore = new PizzaStore(nyPizzaFactory);
        Pizza nyPizza = nyPizzaStore.orderPizza("ny");
        System.out.println("Pizza is provided!" + nyPizza.toString());

        ChicagoPizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();
        PizzaStore chicagoPizzaStore = new PizzaStore(chicagoPizzaFactory);
        // chicagoPizzaStore 需要注入一个Chicago工厂
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza("chicago");
        System.out.println("Pizza is provided!" + chicagoPizza.toString());


    }




}
