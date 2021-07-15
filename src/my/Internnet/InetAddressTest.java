package my.Internnet;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {
    public static void display() {
        byte[] buf = new byte[100];
        try {
            System.out.println("请输入主机名：");//DESKTOP-3VFQB19
            int count = System.in.read(buf);
            String hostName = new String(buf, 0, count-1);
            //获取该主机所有IP地址
            InetAddress inetAddresses[] = InetAddress.getAllByName(hostName);
            System.out.println();
            System.out.println("主机" + inetAddresses[0].getHostName() + "有如下IP地址");
            for (InetAddress addInfo : inetAddresses) {
                System.out.println(addInfo.getHostAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
    }

}
