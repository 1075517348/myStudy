package my.Internnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //创建套接字对象
        DatagramSocket ds = new DatagramSocket(8888);
        //创建接收数组
        byte[] bys = new byte[1024];
        //创建数据包对象
        DatagramPacket dp = new DatagramPacket(bys, bys.length);
        //接收数据
        ds.receive(dp);
        //获取接收的数据
        String id = dp.getAddress().getHostAddress();
        System.out.println("客户端id=" + id);
        String content = new String(bys, 0, dp.getLength());
        System.out.println("客户端数据=" + content);
        int port = dp.getPort();
        System.out.println("客户端端口=" + port);
        //关闭套接字资源
        ds.close();
    }
}