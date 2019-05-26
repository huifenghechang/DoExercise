package A06_CommandPattern.CantingExample;

public class HamburgerOrder implements Order {
    WesternChef chef;

    public HamburgerOrder(WesternChef chef){
        this.chef = chef;
    }
    @Override
    public void OrderUp() {
        chef.cook();
        chef.fire();
    }
}
