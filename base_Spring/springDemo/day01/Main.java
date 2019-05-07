import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args){
        //创建IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc_bean1.xml");
        // 从IOC容器中取出Bean
       /* User user = (User) context.getBean("user");
        User user1 = (User) context.getBean("user");

        //调用Bean的方法
        user.setName("GeNanNan");
        System.out.println(user);
        System.out.println(user1);*/

        /*Book book = (Book) context.getBean("book");
        System.out.println(book.getBookName());*/

        // 注入对象属性
        UserService userService = (UserService) context.getBean("userService");
        userService.getUserDao().add();

       // 注入复杂对象属性
       /* Shop shop = (Shop) context.getBean("shop");
        System.out.println(shop.getArrs()[0]);
        System.out.println(shop.getList());
        System.out.println(shop.getMap());*/

       // 注解创建对象
       /* Boss boss = (Boss) context.getBean("boss");
        System.out.println(boss);
        boss.sell();*/
    }
}
