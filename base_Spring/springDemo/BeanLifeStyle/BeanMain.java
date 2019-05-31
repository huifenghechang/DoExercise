import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanMain {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new
                            ClassPathXmlApplicationContext("spring-beans.xml");

        /*Demo1 demo1 = (Demo1) context.getBean("demo2");
        demo1.sayLove();*/

      /*  Demo2 demo2 = (Demo2) context.getBean("demo2");
        demo2.sayIntroduction();*/

      /*Demo3 demo3 = (Demo3) context.getBean("demo3");
      demo3.sayIntroduction();*/



    }
}
