package A04_FactoryPattern.FactoryMethodPattern;

import A04_FactoryPattern.Pizza;

/*
* 此时，PizzaStore为一个抽象类
* */
public abstract class PizzaStore {

    /*
    * 这种情况下，不需要更改orderPizza()函数
    * */
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    // 此处重要，createPizza为工厂方法，为抽象方法
    protected abstract Pizza createPizza(String type);
}
