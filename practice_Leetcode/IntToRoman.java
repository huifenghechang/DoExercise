import javax.management.RuntimeErrorException;
import java.util.HashMap;

public class IntToRoman {

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999){
            throw new IllegalArgumentException("The num is not legal");
        }
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"I");map.put(4,"IV");map.put(5,"V");

        map.put(10,"X");map.put(9,"IX");
        map.put(50,"L");map.put(40,"XL");
        map.put(100,"C");map.put(90,"XC");
        map.put(500,"D"); map.put(400,"CD");
        map.put(1000,"M");
        map.put(900,"CM");


        String res = "";
        int count = 3;
        int remain = num;

        while (count >= 0){
            int key = (int) Math.pow(10,count); // key依次为 1000；100；10；1
            int quotient = remain / key;
            remain = num % key;

            if (quotient > 0){
                // 当数字大于等于4时，需要做特殊的处理
                if (quotient >= 4  ){
                    if (quotient == 4 || quotient == 5 || quotient ==9){
                        res += map.get(quotient*key);
                        quotient = 0;
                    }else {
                        res += map.get(5*key);
                        quotient -= 5;
                    }

                    while (quotient > 0){
                        // 判断，是否来到各位书
                        res += map.get(key);
                        quotient--;
                    }
                }else {
                    while (quotient > 0) {
                        // 判断，是否来到各位书
                        res += map.get(key);
                        quotient--;
                    }
                }
            }
            count--;

        }
        return res;
    }

    public static void main(String[] args){ ;
        System.out.println(intToRoman(3));
    }
}
