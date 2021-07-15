package my.Internnet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest implements Runnable {
    Thread thread;

    public void run() {
        DataOutputStream outStream;
        DataInputStream inStream;
        try {
            String str;
            //创建服务器Socket并监听端口8888
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            outStream = new DataOutputStream(socket.getOutputStream());
            inStream = new DataInputStream(socket.getInputStream());
            InetAddress address = socket.getInetAddress();
            System.out.println("接收来自：" + address.getHostAddress() + "的连接");
            //发送响应信息
            outStream.writeUTF("1");
            while (true) {
                //从服务器读取数据
                str = inStream.readUTF();
                System.out.println("客户端信息：" + str);
                str = String.valueOf(Integer.parseInt(str) + 1);
                //向服务器发送数据
                outStream.writeUTF(str);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void start() {
        thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        ServerTest app = new ServerTest();
        app.start();
    }
}
