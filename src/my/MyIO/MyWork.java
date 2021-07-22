package my.MyIO;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;


public class MyWork {
    public static void main(String[] args) {
//        encoderStringToFile("梁文浩", "word.txt");
//        enterTry("word.txt");
//        searchWord("word.txt", "java");
//        inputData("word.txt", true);
//        serializableObject("word.txt", new Student("Servant", 24, "男"));
        deSerializableObject("word.txt");

    }

    /**
     * 编写程序，使用字符输入、输出流读取文件，将一段文字加密后存入文件，然后再读取，并将加密前和加密后的文件输出。
     */
    private static void encoderStringToFile(String str, String fileName) {
        File file = new File(fileName);
        try {
            //如果指定文件不存在就创建
            if (!file.isFile()) {
                file.createNewFile();
            }
            System.out.println("加密前的文件：");
            //读取并输出当前文件内容
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = null;
            //做一个字符串集合来存储每行的字符串
            ArrayList<String> strings = new ArrayList<>();
            while ((s = bufferedReader.readLine()) != null) {
                strings.add(s);
                System.out.println(s);
            }
            bufferedReader.close();
            fileReader.close();
            //写入指定字符串
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (!strings.isEmpty()) {
                for (String string : strings) {
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                }
            }
            //对字符串进行加密操作并写入
            bufferedWriter.write(encrypt_MD5(str));
            bufferedWriter.close();
            //打印添加入后的文件内容
            System.out.println("加密后的文件：");
            FileReader fileReader2 = new FileReader(file);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String s2 = null;
            while ((s2 = bufferedReader2.readLine()) != null) {
                System.out.println(s2);
            }
            bufferedReader2.close();
            fileReader2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * MD5加密
     * @param str 需要加密的参数
     * @return
     * @throws Exception
     */
    public static String encrypt_MD5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }

    /**
     * 1.从标准设备中输入若干行英文句子，直到输入”bye“结束，将这些字符串写入文件。
     */
    public static void enterTry(String fileName) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String s = null;
        //循环获得输入的数据
        while (true) {
            s = sc.nextLine();
            if (s.equals("bye")) break;
            //将输入的数据插入到集合中
            str.append(s + "\n");
        }
        //生成文件实例
        File file = new File(fileName);
        try {
            //生成文件流
            FileWriter fouWriter = new FileWriter(file, true);
            //缓存流
            BufferedWriter bufWriter = new BufferedWriter(fouWriter);
            bufWriter.write(str.toString());
            //关闭流
            bufWriter.close();
            fouWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2.在1的基础上，在刚输入的文件中查找单词，打印出包含了要查找单词的所有文本行
     */
    public static void searchWord(String fileName, String search) {
        //获取流
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = null;
            while (true) {
                str = bufferedReader.readLine();
                if (null == str) break;
                if (str.indexOf(search) != -1) System.out.println(str);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3.使用DataInputStream输入一个整型数、一个双精度数和一个字符串型到文件中。
     * 然后用DataOutputStream将这些文件读出并打印到标准输出设备。
     */
    public static void inputData(String fileName, Boolean isRead) {
        File file = new File(fileName);
        try {
            if (isRead) {
                InputStream inputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                System.out.println(dataInputStream.readInt());
                System.out.println(dataInputStream.readDouble());
                System.out.println(dataInputStream.readUTF());
            } else {
                OutputStream outputStream = new FileOutputStream(file);
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeInt(123);
                dataOutputStream.writeDouble(51.23);
                dataOutputStream.writeUTF("like java");
                dataOutputStream.close();
                outputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4.新键一个Student类，该类包含姓名、年龄、性别等属性，该类实现Serializable接口。
     *
     * 见下方的Student类
     */


    /**
     * 5.新键一个测试类，把Student类的一个实例序列化保存到student.dat文件中
     */
    public static void serializableObject(String fileName, Object object) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 6.使用反序列化，把student.dat文件中保存的学生信息反序列化并打印其中的信息
     */
    public static void deSerializableObject(String fileName) {
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(f);
            //使用ObjectInputStream中的readObject()方法进行反序列化
            Student cst = (Student) in.readObject();
            System.out.println(cst.toString());
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

class Student implements Serializable {
    //序列化
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}