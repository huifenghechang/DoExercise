import javax.management.RuntimeErrorException;
import java.util.HashMap;

public class T12_IntToRoman {

    /*
    * 数字转化，最重要的是每个数字的基数。
    * 原数与基数相除，变得到该位上的数字。
    * */
    public static String intToRoman190326(int num) {
        String[][] m = { {"", "M", "MM", "MMM"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
        };

        int[] d ={1000,100,10,1};
        String res = "";
        for (int i=0; i< d.length;i++){
            res  += m[i][num/d[i]];
            num = num % d[i];
        }
        return res;


    }

    public static String intToRoman190316(int num) {
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
        System.out.println(intToRoman190326(9));
    }
}
