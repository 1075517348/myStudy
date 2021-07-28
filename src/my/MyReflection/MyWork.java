package my.MyReflection;

import java.lang.reflect.Array;

/**
 * 利用反射实现通用扩展数组长度的方法。
 */
public class MyWork {
    public static void main(String[] args) {
        text t = new text();
        t.print();

        text.i = (int[]) addArray(t.i, 10);
        text.s = (String[]) addArray(t.s, 10);

        t.print();
    }

    // 实现扩展的方法
    public static Object addArray(Object array, int length) {
        Object newArray = null;
        Class obj = array.getClass().getComponentType();// 获取原数组的类型
        newArray = Array.newInstance(obj, length);// 根据获取的数组类型，创建一个长度为length的新数组
        System.arraycopy(array, 0, newArray, 0, Array.getLength(array));// 将原数组中的内容复制到新数组中
        return newArray;

    }

}

class text {

    static int[] i = {1, 2, 3};// 创建int型数组
    static String[] s = {"c", "z", "m"};// 创建String型数组

    public void print() {
        // 遍历数组
        for (int x = 0; x < i.length; x++) {
            System.out.print("i[" + x + "]=" + i[x] + ",");
        }
        System.out.println();

        for (int j = 0; j < s.length; j++) {
            System.out.print("s[" + j + "]=" + s[j] + ",");
        }
        System.out.println();
    }
}
