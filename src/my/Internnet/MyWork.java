package my.Internnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class MyWork {
    public static void main(String[] args) {
        // getPortInfo(8888);
        openServerSocket();
    }

    /**
     * 编写程序，获取指定端口的主机名、主机地址、本机地址
     * <p>
     * 注意，需要先开启一个主机服务器才能测试。
     */
    public static void getPortInfo(int port) {
        try {
            //获取本机InetAddress对象
            InetAddress inetAddress = InetAddress.getLocalHost();
            //获取本机地址
            String mainHostAddress = inetAddress.getHostAddress();
            System.out.println(mainHostAddress);
            //用本机InetAddress对象加端口，生成套接字对象
            Socket socket = new Socket(inetAddress, port);
            //根据套接字获取InetAddress对象
            InetAddress searInet = socket.getInetAddress();
            //输出内容
            System.out.println("主机名：" + searInet.getHostName() + "，主机地址：" + searInet.getHostAddress() + "，本机地址：" + mainHostAddress);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 编写TCP程序，实现创建一个在8001端口上等待的ServerSocket对象，当接收到一个客户机的连接请求后，程序从客户机建立了连接的Socket对象中获取输入输出流。通过输出流向客户机发送信息
     */
    public static void openServerSocket() {
        ServerSocket serverSocket = null;
        Socket server = null;
        try {
            serverSocket = new ServerSocket(8001);
            server = serverSocket.accept();
            InputStream input = server.getInputStream();
            byte[] bys = new byte[1024];
            int len = input.read(bys);
            System.out.println("客户端信息：" + new String(bys, 0, len));
            OutputStream out = server.getOutputStream();
            byte[] obys = new String("测试").getBytes(StandardCharsets.UTF_8);
            out.write(obys);
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 编写聊天室程序
     */
}
