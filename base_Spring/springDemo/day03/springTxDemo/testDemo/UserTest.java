package springTxDemo.testDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTxDemo.service.UserService;

public class UserTest {

    @Test
    public void testUser(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("tx-demo.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.addUser("NanBao");
    }
}
