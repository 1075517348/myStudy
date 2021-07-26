package my.Internnet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyTest {
    public static void main(String[] args) {
        InetAddress inetAddress = null;
        DataOutputStream outStream = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8001);
            outStream = new DataOutputStream(socket.getOutputStream());
            InetAddress address = socket.getInetAddress();
            System.out.println("连接到服务器：" + address.getHostAddress());
            outStream.writeUTF("你好");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String str = inputStream.readUTF();
            System.out.println("服务器端信息：" + str);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
