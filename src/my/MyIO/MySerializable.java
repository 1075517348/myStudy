package my.MyIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Customer implements Serializable { //创建序列化对象
    private static final long serialVersionUID = 1l;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name=" + name + ",age=" + age;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//建立一个测试类，将Customer对象内部保存的数据序列化操作，并保存到指定文件中。
public class MySerializable {
    public static void main(String[] args) {
        try {
            FileOutputStream f = new FileOutputStream("word.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            Customer customer = new Customer("Ser Vant", 21);
            //使用ObjectOutputStream对象的writeObject()方法进行序列化
            out.writeObject(customer);
            out.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}