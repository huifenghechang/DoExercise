package A06_CommandPattern.CantingExample;

public class HuiCaiOrder implements Order {
    HuiCaiChef huiCaiChef;

    public HuiCaiOrder(HuiCaiChef chef){
        this.huiCaiChef = chef;
    }

    @Override
    public void OrderUp() {
        huiCaiChef.cook();
        huiCaiChef.fire();
    }
}
