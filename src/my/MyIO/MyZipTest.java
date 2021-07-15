package my.MyIO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class MyZipTest {
    /**
     * 压缩方法
     *
     * @param zipFileName
     * @param inputFile
     * @throws Exception
     */
    private void zip(String zipFileName, File inputFile) throws Exception {
        FileOutputStream file = new FileOutputStream(zipFileName); //生成一个FileOutputStream类对象
        ZipOutputStream out = new ZipOutputStream(file); //生成一个ZipOutputStream类对象，
        zip(out, inputFile, "");  //调用自身重构方法
        System.out.println("压缩中...");
        out.close(); //关闭流
    }

    /**
     * 压缩方法
     *
     * @param out
     * @param f
     * @param base
     * @throws Exception
     */
    private void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) { //判断文件是否是一个目录
            File[] fl = f.listFiles(); //获取路径数组
            if (base.length() != 0) {
                out.putNextEntry(new ZipEntry(base + "/")); //写入此目录的entry
            }
            for (int i = 0; i < fl.length; i++) {  //循环遍历数组中的文件
                zip(out, fl[i], base + fl[i]); //再次调用自己
            }
        } else {
            out.putNextEntry(new ZipEntry(base));  //创建新的进入点
            FileInputStream in = new FileInputStream(f); //创建FileInputStream对象
            int b;
            System.out.println(base);
            while ((b = in.read()) != -1) {   //如果没达到流的尾部
                out.write(b);           //将当前字节写入ZIP条目
            }
            in.close();  //关闭流
        }
    }

    /**
     * 解压操作(这个方法有问题，还没检查出来，先不搞了)
     *
     * @param fileName
     * @param path
     * @throws Exception
     */
    private static void decompressing(String fileName, String path) throws Exception {
        File file = new File(fileName); //当前压缩文件
        ZipInputStream zin;  //创建ZipInputStream对象
        ZipFile zipFile = new ZipFile(file); //创建压缩文件对象
        zin = new ZipInputStream(new FileInputStream(file)); //实例化对象，指明要解压的文件
        ZipEntry entry = zin.getNextEntry();    //跳过根目录，获取下一个ZipEntry
        while (((entry = zin.getNextEntry()) != null) && !entry.isDirectory()) { //entry不是目录且不为空
            File tmp = new File(path + entry.getName());  //解压出的文件路径
            if (!tmp.exists()) {  //如果文件不存在
                tmp.getParentFile().mkdirs();  //创建文件父类文件夹路径
                OutputStream os = new FileOutputStream(tmp); //将文件目录中的文件放入输出流
                //用输入流读取压缩文件中制定目录中的文件
                InputStream in = zipFile.getInputStream(entry);
                int count = 0;
                while ((count = in.read()) != -1) {
                    os.write(count);
                }
                os.close();
                in.close();
            }
            zin.closeEntry();
            System.out.println(entry.getName() + "解压成功");
        }
        zin.close();
    }

    public static void main(String[] args) {
        //压缩文件夹
//        MyZipTest book = new MyZipTest(); //创建本类实例
//        try {
//            //调用方法，参数为压缩后的文件与要压缩的文件夹
//            book.zip("E:/word.zip", new File("E:/word"));
//            System.out.println("压缩完成");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //解压
        try {
            decompressing("E:/word.zip", "E:/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
