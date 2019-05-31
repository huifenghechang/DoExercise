package A05_SingletonPattern;

public class ChocolateBoiler {
    private static ChocolateBoiler uniqueInstance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler(){
        this.empty = true;
        this.boiled = false;
    }

    public static ChocolateBoiler getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }
}
