package my.Internnet;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionTest {
    public static void display() {
        byte buf[] = new byte[100];
        try {
            System.out.println("请输入URL：");
            int count = System.in.read(buf);
            String address = new String(buf, 0, count);
            URL url = new URL(address);
            //创建URLConnection对象
            URLConnection c = url.openConnection();
            //建立连接
            c.connect();
            System.out.println("内容类型：" + c.getContentType());
            System.out.println("内容编码：" + c.getContentEncoding());
            System.out.println("内存长度：" + c.getContentLength());
            System.out.println("创建日期：" + new Date(c.getDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        display();
    }
}
