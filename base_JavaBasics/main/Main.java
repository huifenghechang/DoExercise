package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        inAndOutName();
//        inAndOutIntroduction();
        int flag = 1;
        int counter = 0;
        while (flag != 0){
            flag = flag << 1;
            counter++;
            System.out.print(counter + ";");
        }

    }

    public static void  inAndOutName(){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();
        System.out.println(name);
    }

    public static void  inAndOutIntroduction(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = input.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
