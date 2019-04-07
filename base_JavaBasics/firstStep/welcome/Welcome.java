package firstStep.welcome;

import java.math.BigDecimal;
import java.util.Scanner;

public class Welcome {

    static class Man {
        private int id;
        private static int nextId = 1;

        public void setId(){
            this.id = nextId;
            nextId++;
        }

        public void hello(){

        }

        public void hello8(){

        }

        public void hello11(){

        }


    }

    enum Size{SMALL,MDEIUM,LARGE,EXTRA_LARGE};

    public static void main(String[] args){
      /*  Number array[] = {1,3,4,5,6,2};
        Number max = getMax(array);

        System.out.println(max);*/
      /*char c = '碎';
      int i = 8;
      int y = -i++;
      System.out.println(y);*/

      double d1 = 2.15;
      double d2 = 1.10;
      double f = 0.92933457788845;
      short a1 = 9;
      short a2 =19;
      /*
      System.out.println("double 类型运算的结果："+(d2-d1));

      BigDecimal v1 = new BigDecimal("2.15");
      BigDecimal v2 = new BigDecimal("1.10");
      System.out.println("BigDecimal类型的结果"+ v2.subtract(v1));
      System.out.println("float类型的结果"+ f);
      */





    }

    // 通过 extends 关键字可以限制泛型的类型
    public static  <T extends Number> T getMax(T array []){
        T max = array[0];
        for (T element : array){
            max = element.doubleValue() > max.doubleValue() ? element : max;
        }
        return max;
    }
}
