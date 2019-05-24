package A04_FactoryPattern.FactoryPattern;

import java.util.List;

public interface PizzaIngredientFactory {
    public String createDough();
    public String createSauce();
    public String createCheese();
    public String[] createVeges();
}

