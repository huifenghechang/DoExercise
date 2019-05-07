import aop.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        Book book = (Book) context.getBean("book");
        book.add();
    }
}
