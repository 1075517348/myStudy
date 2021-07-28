package my.Internnet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

// 用来写我自己的各种测试样例
public class MyTest {
    public static void main(String[] args) throws Exception {
        // 创建客户的socket
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8888);
        // 获得socket输出流
        OutputStream out = socket.getOutputStream();
        // 创建文件字节输入流
        FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Pictures\\Saved Pictures\\weiniweini.png");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            // 通过out向服务器端输出文件数据
            out.write(buf, 0, len);
        }
        // 客户端发送数据完毕，结束Socket输出流的写入操作，告知服务器端
        socket.shutdownOutput();

        System.out.println(out);

        // 获得socket输入流对象，读取服务器返回的内容：上传成功
        InputStream in = socket.getInputStream();
        len = in.read(buf);
        System.out.println(new String(buf, 0, len));
        // 关闭资源
        socket.close();
        fis.close();

    }
}
