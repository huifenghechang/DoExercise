package A03_DecoratorPattern;

public class DecoratorDemoTest {
    public static void main(String[] args){
//        DarkRoast darkRoast = new DarkRoast();
//        MochaDecorator mochaDecorator = new MochaDecorator(darkRoast);
//        SoyDecorator soyDecorator = new SoyDecorator(mochaDecorator);
//        System.out.printf("The orderList is : %s and the Price is : %f",soyDecorator.getDescription(),soyDecorator.cost());
//
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + "$："+ beverage1.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new MochaDecorator(beverage2);
        beverage2 = new SoyDecorator(beverage2);
        beverage2 = new WhipDecorator(beverage2);


        System.out.println(beverage2.getDescription() + "$："+ beverage2.cost());

    }
}
