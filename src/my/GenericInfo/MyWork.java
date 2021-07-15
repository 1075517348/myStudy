package my.GenericInfo;


import my.test.A;

import java.io.*;
import java.util.*;

public class MyWork {

    public static void main(String[] args) {
        try {
            String fileName = "fileTest.txt";
            FileInputStream fileInputStrem = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStrem);
            String newFileName = "newTest.txt";
            FileOutputStream fileOutStream = new FileOutputStream(newFileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutStream);
            int ch = 0;
            while ((ch = inputStreamReader.read()) != -1) {
                System.out.print((char) ch);
                outputStreamWriter.write(ch);
            }
            System.out.println("Sucess Copy");
            inputStreamReader.close();
            outputStreamWriter.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No Such File");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.模拟骰子游戏
     * <p>
     * 同时投掷两个骰子5000次，每次骰子上共有1~6的6个数字，计算每次骰子结果的数值之和，并统计和输出每种可能的结果在模拟过程中出现的总次数。
     */
    public static void diceGame() {
        int sum;
        //思路上说用穷举来做，此处我用Map集合来做，效率好像比较低
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            //两个骰子加起来的结果
            sum = random.nextInt(6) + random.nextInt(6) + 2;
            //判断集合里有没有其中某个结果
            if (map.containsKey(sum)) {
                //键值-值
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        //先转换为Set集合
        Set<Integer> set = map.keySet();
        //使用迭代器循环输出
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            Integer value = (Integer) map.get(key);
            System.out.println("和:" + key + "，统计" + value);
        }

    }

    /**
     * 2.求集合的并集、交集和差集
     * <p>
     * 设有两个集合，如A={1,2,3,4}，B={1,3,7,9,11}，编写代码求它们的并集，交集和差集
     */
    public static void CollectionRelation() {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(3);
        B.add(7);
        B.add(9);
        B.add(11);
        System.out.println("A：" + A);
        System.out.println("B：" + B);
        //做一个新集合存储并集
        ArrayList<Integer> C = new ArrayList<>();
        C.addAll(B);
        C.addAll(A);
        System.out.println("有重复并集：" + C);
        //做一个新集合存储交集
        ArrayList<Integer> D = new ArrayList<>();
        D.addAll(A);
        D.retainAll(B);
        System.out.println("交集：" + D);
        //做一个新集合存储差集
        ArrayList<Integer> E = new ArrayList<>();
        E.addAll(A);
        E.removeAll(B);
        System.out.println("A对B差集：" + E);
        //做一个新集合存储差集
        ArrayList<Integer> F = new ArrayList<>();
        F.addAll(B);
        F.removeAll(A);
        System.out.println("B对A差集：" + F);
        //做一个新集合存储并集
        ArrayList<Integer> G = new ArrayList<>();
        G.addAll(A);
        G.addAll(F);
        System.out.println("无重复并集：" + G);
    }

    /**
     * 3.按学生人数对高校排名
     * <p>
     * 学校信息：
     * 北理工 21000人，北京师 25000，吉林大 20000，中山大 18000，暨南大 7000
     */
    public static void schoolSort() {
        Map<String, Integer> map = new HashMap<>();
        map.put("暨南大", 7000);
        map.put("北理工", 21000);
        map.put("中山大", 18000);
        map.put("北京师", 25000);
        map.put("吉林大", 20000);
        System.out.println(sortMap(map));
    }

    //Map排序配合第3问题使用
    public static LinkedHashMap<String, Integer> sortMap(Map<String, Integer> map) {
        //自定义类保存键值对
        class MapClass {
            private String key;
            private int value;

            public MapClass(String key, int value) {
                super();
                this.key = key;
                this.value = value;
            }

            public String getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }
        }
        //为自定义类实现排序方法
        class MapSortMethod implements Comparator<MapClass> {
            @Override
            public int compare(MapClass o1, MapClass o2) {
                //按值大小升序排列
                int result = Integer.compare(o1.getValue(), o2.getValue());
                //按值大小降序排列
                //int result = Integer.compare(o2.getValue(), o1.getValue());
                if (result != 0)
                    return result;
                //值相同时按键字典顺序排列
                return o1.getKey().compareTo(o2.getKey());
            }
        }
        //以ArrayList保存自定义类
        ArrayList<MapClass> mapclass = new ArrayList<MapClass>();
        for (String k : map.keySet())
            mapclass.add(new MapClass(k, map.get(k)));
        //使用Collections.sort()方法，第二个参数为自定义排序方法，需要实现Comparator接口
        Collections.sort(mapclass, new MapSortMethod());
        //用LinkedHashMap返回排好序的Map
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (MapClass m : mapclass)
            sortedMap.put(m.getKey(), m.getValue());
        return sortedMap;
    }

    /**
     * 测试Map
     * <p>
     * 建立一个Map集合，使得表中的关键字用Integer类型，值用String类型，并向其中填入数据（可以填入其它类来测试进行体会），然后按关键字值排序输出
     */
    public static void testMap() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(6, "A");
        map.put(2, "B");
        map.put(1, "C");
        map.put(9, "ssss");
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println("key:" + key + ",value:" + value);
        }
    }


    /**
     * 综合题
     * <p>
     * 设有一数列：a<sub>1</sub> = 3,a<sub>2</sub>=8,a<sub>3</sub>=22···,an = 2a<sub>n-1</sub>+2a<sub>n-2</sub>，使用堆栈结构输出a<sub>n</sub>的若干项
     */
    public static void calculateAn(int num) {
        //栈(stack)，又称堆栈，它是运算受限的线性表，其限制是仅允许在表的一端进行插入和删除操作，不允许在其他任何位置进行添加、查找、删除等操作
        LinkedList<Integer> linkedList = new LinkedList<>();
        switch (num) {
            case 0:
                break;
            case 1:
                linkedList.add(3);
                break;
            case 2:
                linkedList.add(3);
                linkedList.add(8);
                break;
            default:
                linkedList.add(3);
                linkedList.add(8);
                for (int i = 2; i < num; i++) {
                    linkedList.add(linkedList.get(i - 1) * 2 + linkedList.get(i - 2) * 2);
                }
                break;
        }
        for (Integer integer : linkedList) {
            System.out.print(integer + " ");
        }
    }

    /**
     * 映射结构题
     * <p>
     * 利用映射结构保存由学号和姓名组成的键-值对，按学号的自然顺序将这些键-值对一一打印出来
     */
    public static void mapTest() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(4, "梁文浩");
        map.put(5, "魏洪财");
        map.put(1, "肖学斌");
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            System.out.println("ID：" + i + "，姓名：" + map.get(i));

        }
    }
}

/**
 * 测试List
 * <p>
 * 编写一个类，在类中定义两个静态方法：
 * printElement用于输出元素类型是Number的List表中的元素；
 * addElement用于向List表中添加Number及其子类元素；
 * 进行测试
 */
class TestList {
    public static List<Number> list = new ArrayList<>();

    public static void printElement() {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    public static void addElement(Number number) {
        list.add(number);
    }
}

/**
 * 测试泛型
 * <p>
 * 编写一个程序定义泛型类，要求该类中能容纳5个同种类型元素，能输出这些元素的值，也能获取和修改元素
 *
 * @param <T> 泛型数据
 */
class GenericTest<T> {
    private ArrayList<T> arrayList = new ArrayList<>();

    public GenericTest() {
    }

    public GenericTest(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    //输出元素
    public void printElement() {
        for (T t : arrayList) {
            System.out.println(t.toString());
        }
    }

    //添加元素
    public void addElement(T value) {
        arrayList.add(value);
    }

    //获取元素
    public T getElement(int i) {
        T info = arrayList.get(i);
        return info;
    }

    //改变元素
    public void changeElement(int i, T newValue) {
        arrayList.set(i, newValue);
    }
}

/**
 * 撰写Comparable泛型类
 * <p>
 * 自定义一个Comparable的泛型类，并进行测试.
 */
class ComparableTest<T> implements Comparable<ComparableTest> {
    private int number;

    public ComparableTest(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(ComparableTest o) {
        return this.number - o.number;
    }
}

/**
 * 按以下要求进行操作
 * <p>
 * (1)按注释里的要求实现其中的方法
 * (2)定义一个测试类，用以验证NumberList类的正确性
 */
class NumberList {
    private ArrayList al;

    public NumberList(int[] value) {
        al = new ArrayList();
        //将数组value中的元素添加到al中
        for (int i = 0; i <= value.length - 1; i++) {
            Integer integer = Integer.valueOf(value[i]);
            al.add(integer);
        }

    }

    Map count() {
        //统计al中每个元素出现的次数，将”元素值，这个元素出现的次数“作为键值对保存到Map对象中。
        Map<Integer, Integer> map = new HashMap<>();
        for (Object o : al) {
            if (map.get((int) o) == null) {
                map.put((int) o, 1);
            } else {
                map.put((int) o, map.get((int) o) + 1);
            }
        }
        return map;
    }
}