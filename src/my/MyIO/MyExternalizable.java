package my.MyIO;

import java.io.*;
import java.util.Date;

public class MyExternalizable {
    public static void main(String[] args) {
        serialize("word.txt");
        System.out.println("序列化完成");
        /*deserialize("word.txt");
        System.out.println("反序列化完成");*/
    }

    //序列化对象到文件
    public static void serialize(String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(f);
            UserInfo user = new UserInfo("Ser Vant", "888888", 20);
            //使用ObjectOutputStream的writeObject方法进行序列化
            out.writeObject(user);
            out.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从文件反序列化到对象
    public static void deserialize(String fileName) {
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(f);
            //使用ObjectInputStream的readObject方法进行反
            UserInfo user = (UserInfo) (in.readObject());
            System.out.println(user.toString());
            in.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class UserInfo implements Externalizable {
    public String userName;
    public String userPass;
    public int userAge;

    public UserInfo() {

    }

    public UserInfo(String userName, String userPass, int userAge) {
        this.userName = userName;
        this.userPass = userPass;
        this.userAge = userAge;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("现在开始序列化方法");
        Date d = new Date(); //可在序列化的时候写非自身变量
        out.writeObject(d);
        out.writeObject(userName);
        out.writeObject(userPass);
        out.writeObject(userAge);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("现在执行反序列化方法");
        Date d = (Date) in.readObject();
        System.out.println(d);
        this.userName = (String) in.readObject();
        this.userPass = (String) in.readObject();
        this.userAge = (Integer) in.readObject();
    }

    @Override
    public String toString() {
        return "用户名：" + this.userName + "，密码：" + this.userPass + "年龄：" + this.userAge;
    }
}