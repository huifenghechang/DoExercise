package c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

    @Test
    public void testService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("c3po.xml");
        StudentService service = (StudentService) context.getBean("studentService");
        service.addStudent();
    }
}
