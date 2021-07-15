package my.MyIO;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * 编写程序，使用字符输入、输出流读取文件，将一段文字加密后存入文件，然后再读取，并将加密前和加密后的文件输出。
 */
public class MyWork {
    public static void main(String[] args) {
        encoderStringToFile("梁文浩", "word.txt");
    }

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

}
