package weBank;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
*
*
* */
public class Title_02 {

    public static void main(String[] args) throws IOException {
        int num = 0;
        System.out.println("请输入数字");
        InputStream input = System.in;
        //读取数据
        BufferedReader bufr = new BufferedReader(new InputStreamReader(input));
        //封装成String在转换成int格式
        String data = bufr.readLine();
            try {
                num = Integer.parseInt(data);
            }catch(NumberFormatException e) {
                System.out.println("你输入的不是数字，请重新输入!");
            }
        System.out.println(getTheLimitNums(num));

    }
    public static int getTheLimitNums(int n){
        return n;
    }

}
