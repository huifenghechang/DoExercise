package firstStep.welcome;

import java.io.Console;
import java.util.Scanner;

public class Welcome {

    enum Size{SMALL,MDEIUM,LARGE,EXTRA_LARGE};

    public static void main(String[] args){


        int n = 8;
        int move_to_left = (n << 2);
        int move_to_right = (n >> 2);
        int move_to_three = (n >>> 3);

        String lover = "Ge Nan Nan";
        Size s = Size.LARGE;

        /*StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append("World");
        String hi = builder.toString();*/

       /* Scanner in = new Scanner(System.in);
        System.out.println("How old are you ?");
        int age = in.nextInt();*/


//        System.out.println("Your age is " + age);

        /*System.out.println("move_to_left is" + move_to_left);
        System.out.println("move_to_right is" + move_to_right);
        System.out.println("move_to_three is" + move_to_three);
        System.out.println("my lover is "+ lover.substring(3));
        System.out.println(hi);*/


    }
}
