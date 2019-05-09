package springTxDemo.testDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTxDemo.service.OrderService;

public class OrderTest {

    @Test
    public void transfer(){
        ApplicationContext context = new ClassPathXmlApplicationContext("tx-demo.xml");
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.accountMoney();
    }
}
