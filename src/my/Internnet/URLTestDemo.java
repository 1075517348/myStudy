package my.Internnet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTestDemo {
    public static void display() {
        //建立缓冲区
        byte[] buf = new byte[100];
        URL url;
        try {//获取用户输入URL
            System.out.println("请输入URL（需带上协议）：");
            int count = System.in.read(buf);
            String addr = new String(buf, 0, count);
            url = new URL(addr);
            //打开一个输入流
            InputStream ins = url.openStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(ins));
            //读取数据
            String info = bReader.readLine();
            while (info != null) {
                System.out.println(info);
                info = bReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        URLTestDemo app = new URLTestDemo();
        app.display();
    }
}