package model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "boss")
@Scope(value = "prototype")
public class Boss {
    private String name;
    private int age;
    public void sell(){
        System.out.println("EveryBody ,there is on sale.....");
    }

}
