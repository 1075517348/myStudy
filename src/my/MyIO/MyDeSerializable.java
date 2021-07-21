package my.MyIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyDeSerializable {
    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream("word.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            //使用ObjectInputStream中的readObject()方法进行反序列化
            Customer cst = (Customer) in.readObject();
            System.out.println(cst.getName());
            System.out.println(cst.getAge());
            //关闭流
            f.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
