package my.Internnet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpServer {
    public static void main(String[] args) throws Exception {
        // 创建服务器socket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        // 死循环保证服务器不退出
        while (true) {
            // 获得socket对象
            Socket socket = serverSocket.accept();
            // 开启一个线程
            new Thread(new UploadThread(socket)).start();
        }

    }

    // 上传线程
    public static class UploadThread implements Runnable {
        private Socket socket;

        public UploadThread(Socket socket) {
            this.socket = socket;
        }

        public UploadThread() {
        }

        @Override
        public void run() {
            try {
                // 创建目标文件对象，用来保存上传的文件
                File dir = new File("e:\\java\\uploads");
                dir.mkdirs();
                // 文件名：域名+当前时间毫秒值+6位随机数.png
                String filename = "com.itheima" + System.currentTimeMillis() + ".png";
                FileOutputStream fos = new FileOutputStream(new File(dir, filename));
                // 通过socket对象获得字节输入流对象
                InputStream in = socket.getInputStream();
                // 读取客户端上传的图片数据
                int len = 0;
                byte[] buf = new byte[1024];
                while ((len = in.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                // 向客户端写出：上传成功
                socket.getOutputStream().write("上传成功".getBytes());
                // 关闭资源
                socket.close();
                fos.close();
            } catch (Exception e) {

            }
        }
    }
}