package A04_FactoryPattern;

public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected String[] veges;
    protected double price;

    public abstract void prepare();

    public void bake(){
        System.out.println("baking pizza!");
    }

    public void cut(){
        System.out.println("cutting pizza!");
    }

    public void box(){
        System.out.println("boxed pizza!");

    }

}
