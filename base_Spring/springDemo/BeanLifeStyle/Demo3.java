import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Demo3 {
    @PostConstruct
    public void initPostConstruct(){
        System.out.println("执行PostConstruct注解标注的方法");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("执行preDestroy注解标注的方法");
    }

    public void sayIntroduction(){
        System.out.println("I am Demo3 !!!");
    }

}
