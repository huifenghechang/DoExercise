package springTxDemo.service;

import org.springframework.transaction.annotation.Transactional;
import springTxDemo.dao.OrderDao;

@Transactional
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //编写业务代码
    public void accountMoney(){
        orderDao.lessMoney();

        int k = 99 / 0;
        orderDao.moreMoney();
    }
}
