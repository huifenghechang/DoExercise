package factory;

import model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountryFactory {
    public static Country getCountryInstance(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc-bean2.xml");
        return (Country) context.getBean("country");
    }
}
