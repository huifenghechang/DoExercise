package A06_CommandPattern.ControllerExample;

public class Light {
    String name;

    public Light(){
        this.name = "Light";
    }

    public void on(){
        System.out.println("Light is on ...");
    }

    public void off(){
        System.out.println("Light is off ...");
    }
}
