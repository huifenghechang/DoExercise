package A06_CommandPattern.CantingExample;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Waiter implements Order{
    Order order;

    public void takeOrder(Order order){
        this.order = order;
    }

    @Override
    public void OrderUp() {
        order.OrderUp();
    }
}
