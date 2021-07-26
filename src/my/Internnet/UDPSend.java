package my.Internnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        //创建套接字对象
        DatagramSocket ds = new DatagramSocket();
        //将数据封装到数组
        byte[] bys = "黑马程序员".getBytes();
        InetAddress id = InetAddress.getLocalHost();
        int port = 8888;
        //创建数据包
        DatagramPacket dp = new DatagramPacket(bys, bys.length, id, port);
        //发送数据
        ds.send(dp);
        //关闭套接字资源
        ds.close();
    }
}
