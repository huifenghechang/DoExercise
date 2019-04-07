package NewCoder;

import java.util.Scanner;

public class NK_bigNumberMultiply {

  /*  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String res = "";
        if (str1 == null || str2 == null){
            res = null;
        }

        if (str1.charAt(0) == '0' || str2.charAt(0) == '0'){
            res += '0';
        }
        res = multiply(str1,str2);
        System.out.println(res);
    }*/

  public static void main(String[] args){
      String x = "12";
      String y = "3";
      System.out.println(multiply(x,y));
  }


    public  static  String multiply(String str1, String str2){
        String num1 = new StringBuffer(str1).reverse().toString();
        String num2 = new StringBuffer(str2).reverse().toString();
        int[] res = new int[num1.length()+num2.length()];

        for (int i=0; i<num1.length(); i++){
            for (int j=0; j<num2.length(); j++){
                res[i+j] += (num1.charAt(i)-'0') *(num2.charAt(j)-'0');
                if (res[i+j] >=10){
                    res[i+j+1] += res[i+j] / 10;
                    res[i+j] = res[i+j] % 10;
                }
            }
        }

        // 把result 数字逆序之后，再洗转换成String
        StringBuffer sb = new StringBuffer();
        boolean findFirst = false;
        for (int i= res.length-1; i >=0; i--){
            if (!findFirst){
                if (res[i]==0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(res[i]);
        }
        return sb.toString();

    }


}
