package A06_CommandPattern.CantingExample;

public class Customer {
    public static void main(String[] args){
        // 餐厅里的厨师、服务员
        WesternChef westernChef = new WesternChef();
        HuiCaiChef huiCaiChef = new HuiCaiChef();
        Waiter waiter = new Waiter();

        // 顾客点餐
        HamburgerOrder hamburgerOrder = new HamburgerOrder(westernChef);

        //服务员接单
        waiter.takeOrder(hamburgerOrder);
        waiter.OrderUp();
    }
}
