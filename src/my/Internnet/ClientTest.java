package my.Internnet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTest implements Runnable {
    Thread thread;

    public void run() {
        Socket socket;
        DataOutputStream outStream;
        DataInputStream inStream;
        try {
            //连接到本地机的8888端口
            socket = new Socket("192.168.19.66", 8888);
            outStream = new DataOutputStream(socket.getOutputStream());
            inStream = new DataInputStream(socket.getInputStream());
            InetAddress address = socket.getInetAddress();
            System.out.println("连接到服务器：" + address.getHostAddress());
            while (true) {
                //从服务器读取数据
                String str = inStream.readUTF();
                System.out.println("服务器端信息：" + str);
                thread.sleep(1000);
                str = String.valueOf(Integer.parseInt(str) + 1);
                //向服务器发送数据
                outStream.writeUTF(str);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void start() {
        thread = new Thread(this);
        //启动线程
        thread.start();
    }

    public static void main(String[] args) {
        ClientTest app = new ClientTest();
        app.start();
    }
}
