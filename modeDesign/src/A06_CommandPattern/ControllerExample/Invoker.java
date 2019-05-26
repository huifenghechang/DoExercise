package A06_CommandPattern.ControllerExample;

public class Invoker implements Command{
    Command slot;

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    @Override
    public void execute() {
        slot.execute();
    }
}
