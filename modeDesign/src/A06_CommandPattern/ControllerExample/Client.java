package A06_CommandPattern.ControllerExample;

public class Client {
    public static void main(String[] args){
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        Invoker invoker = new Invoker();

        invoker.setSlot(lightOnCommand);

        invoker.execute();

    }
}
