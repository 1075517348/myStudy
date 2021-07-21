package my.MyIO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestMyIO implements Serializable {
    private Tree tree = new Tree();

    public static void main(String[] args) {
        TestMyIO f = new TestMyIO();
        try {
            FileOutputStream fs = new FileOutputStream("word.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(f);
            os.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            FileOutputStream fs = new FileOutputStream("word.txt");
//            DataOutputStream ds = new DataOutputStream(fs);
//            ds.writeUTF("使用writeUTF");
//            ds.writeChars("使用writeChars");
//            ds.writeBytes("使用writeByte");
//            ds.close();
//            FileInputStream fis = new FileInputStream("word.txt");
//            DataInputStream dis = new DataInputStream(fis);
//            System.out.println(dis.readUTF());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /*File file = new File("word.txt");
        String[] str = {"测试", "文本", "单行"};
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bufw = new BufferedWriter(fw);
            for (int i = 0; i < str.length; i++) {
                bufw.write(str[i]);
                bufw.newLine();
            }
            bufw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            String s = null;
            int i = 0;
            while ((s = bufr.readLine()) != null) {
                i++;
                System.out.println("第" + i + "行：" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        /*File file = new File("word.txt");
        try {
            //创建FileWriter对象
            FileWriter out = new FileWriter(file);
            //写入文本
            String s = "测试文本";
            out.write(s);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //读取
        try {
            //创建FileReader对象
            FileReader in = new FileReader(file);
            char byt[] = new char[1024];
            int len = in.read(byt);
            System.out.println(new String(byt, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        /*  File file = new File("word.txt"); //创建文件对象
        if (file.exists()) {   //如果文件存在
            file.delete();   //删除文件
        } else {
            try {    //捕捉可能出现的异常
                file.createNewFile();  //创建该文件
                System.out.println("文件已创建");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        /*File file = new File("word.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte buy[] = "1测试文本写入".getBytes(); //此处直接把字符串调用方法转为字节数组
            out.write(buy);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1024]; //创建byte数组
            int len = in.read(byt);
            System.out.print("文件中的信息：" + new String(byt, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}

class Tree {

}