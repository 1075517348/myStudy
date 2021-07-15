package my.Internnet;

import java.io.*;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //声明服务器的Socket类
        Socket serverSocket = null;
        //声明服务端的文件写出类
        PrintWriter printWriter = null;
        //声明服务端的文件读入类
        BufferedReader serverBufferedReader = null;
        //与服务器端的通话状态
        boolean runable = true;
        //声明写到服务端的信息变量
        String toServer;
        try {
            //通过1234端口使客户端接口与服务器接口联系
            serverSocket = new Socket("DESKTOP-3VFQB19", 1234);
            //创建服务端接口的写出类
            printWriter = new PrintWriter(serverSocket.getOutputStream(), true);
            //创建服务端接口的读入类
            serverBufferedReader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("找不到服务器");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("不能获得Socket的读入与写出器");
            e.printStackTrace();
            System.exit(0);
        }
        //创建键盘文件读入类
        BufferedReader keyBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //向服务器输入信息
        printWriter.println("New Client Enter");
        //建立显示服务端信息的线程
        ReadServerThread readServerThread = new ReadServerThread(serverBufferedReader);
        //启动线程
        readServerThread.start();
        //进入与服务器的对话循环
        while (runable) {
            toServer = keyBufferedReader.readLine();
            //向服务器输出信息
            printWriter.println(toServer);
            //当输入信息是Bye的时候退出程序
            if (toServer.equals("Bye")) {
                break;
            }
            //获取线程状态
            runable = readServerThread.runAble;
        }
        readServerThread.fromServer = "Good Bye";
        readServerThread.runAble = false;
        //关闭服务端的文件写出类
        printWriter.close();
        //关闭服务端的文件读入类
        serverBufferedReader.close();
        //关闭键盘文件读入类
        keyBufferedReader.close();
        serverSocket.close();
    }
}

//读取服务端信息的线程
class ReadServerThread extends Thread {
    BufferedReader in = null;
    String fromServer = "";
    boolean runAble = true;

    public ReadServerThread(BufferedReader in) {
        this.in = in;
    }

    public void run() {
        while (runAble) {
            try {
                fromServer = in.readLine();
            } catch (Exception e) {
                runAble = false;
            }
            //当服务器端输入Bye时结束对话程序
            if (fromServer.equals("Bye")) {
                System.out.println("服务器程序退出");
                //结束向服务端写入信息循环
                runAble = false;
                break;
            }
            System.out.println("Service:" + fromServer);
        }
    }
}
