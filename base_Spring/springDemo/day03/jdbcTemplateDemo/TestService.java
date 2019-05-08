package jdbcTemplateDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

    @Test
    public void testDemo(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.add();
    }
}
