package my.Internnet;

import java.io.*;
import java.net.*;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //声明写到客户端的字符串变量
        String toClient;
        //声明客户端的文件写出类
        PrintWriter clientPrintWriter = null;
        //声明客户端的文件读入类
        BufferedReader clientBufferedReader = null;
        //与客户端的通话状态
        boolean runable = true;
        //创建ServerSocket的服务接口
        ServerSocket serverSocket = null;
        try {
            //使该接口应用端口1234
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            System.err.println("不能创建123端口");
            e.printStackTrace();
            System.exit(0);
        }
        //创建Socket的客户接口,当有客户端的程序访问该服务接口时激活该类
        Socket clientSocket = null;
        try {
            //通过accept方法使服务器与客户端的Socket接口建立联系
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("访问端口失败");
            e.printStackTrace();
            System.exit(0);
        }
        //取得客户端的Socket接口的写出类
        clientPrintWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        //取得客户端的Socket接口的读入类
        clientBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //通过键盘输入器建立另一个文件读入器
        BufferedReader keyBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //当有客户端的程序进入时显示欢迎信息
        toClient = "open";
        clientPrintWriter.println(toClient);
        //建立显示客户端信息的线程
        ReadClientThread readClientThread = new ReadClientThread(clientBufferedReader);
        //启动线程
        readClientThread.start();
        //进入与客户端对话程序
        while (runable) {
            //向客户端写出服务器的键入信息
            toClient = keyBufferedReader.readLine();
            clientPrintWriter.println(toClient);
            //如果服务端写入"Bye"退出对话程序
            if (toClient.equals("Bye")) {
                break;
            }
            runable = readClientThread.runAble;
        }
        readClientThread.fromClient = "Close";
        //关闭线程
        readClientThread.runAble = false;
        //关闭客户端的文件写出类
        clientPrintWriter.close();
        //关闭客户端的文件读入类
        clientBufferedReader.close();
        //关闭键盘文件读入类
        keyBufferedReader.close();
        //关闭客户端接口
        clientSocket.close();
        //关闭服务端接口
        serverSocket.close();
    }
}

//读取客户端信息的线程类
class ReadClientThread extends Thread {
    BufferedReader bufferedReader = null;
    String fromClient = "";
    boolean runAble = true;

    public ReadClientThread(BufferedReader in) {
        this.bufferedReader = in;
    }

    public void run() {
        while (runAble) {
            //显示客户端信息
            try {
                fromClient = bufferedReader.readLine();
            } catch (Exception e) {
                runAble = false;
            }
            //当客户端输入Bye时,服务端结束  显示客户端信息,与向客户端写入信息  的两个循环
            if (fromClient.equals("Bye")) {
                System.out.println("Client exit");
                //结束向客户写入信息循环
                runAble = false;
                //结束客户端信息循环
                break;
            }
            System.out.println("Client:" + fromClient);
        }
    }
}
