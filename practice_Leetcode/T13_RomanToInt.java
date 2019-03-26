import java.util.HashMap;
import java.util.TreeMap;

public class T13_RomanToInt {

    public int romanToInt(String s) {
        TreeMap<Character,Integer> map = new TreeMap<>();

        map.put('I',1);map.put('V',5);
        map.put('X',10);map.put('L',50);
        map.put('C',100);map.put('D',500);
        map.put('M',1000);

        int result = 0;
        for (int i=s.length()-1;i>1;i--){
            result += map.get(s.charAt(i));
            if (i>= 1 && map.get(i-1) < map.get(i)){
                result -= map.get(s.charAt(--i));
            }
        }
        return result;

    }

    public int romanToInt190316(String s) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);map.put('V',5);
        map.put('X',10);map.put('L',50);
        map.put('C',100);map.put('D',500);
        map.put('M',1000);

        int result = 0;
        /*
        * 从低位开始往高位累加。
        * */
        for (int i = s.length()-1; i >=0; i--){
            result += map.get(s.charAt(i));
            /*
            * 若左边的数字比当前的小，则减去左边的数字，并向左移动一位 */
            if (i>=1 && map.get(s.charAt(i-1)) < map.get(s.charAt(i))){
                result -= map.get(s.charAt(--i));
            }
        }
        return result;
    }
}
