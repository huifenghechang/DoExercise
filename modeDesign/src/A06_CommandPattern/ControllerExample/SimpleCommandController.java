package A06_CommandPattern.ControllerExample;

// 遥控器，相当于Invoker 调用者。里面存放着槽口和对应的动作。
// 绑定了
public class SimpleCommandController {
    Command slot;

    public SimpleCommandController(){

    }

    public void setCommand(Command command){
        this.slot = command;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}
