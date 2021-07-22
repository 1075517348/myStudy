package my.MyLambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyWork {
    public static void main(String[] args) {
        firstWork();
        secondWork();
        Stream<Integer> stream = Stream.of(1, -2, -3, 4,-5);
        stream.map(Math::abs).forEach(System.out::println);
    }

    /**
     * 1.	请在测试类main方法中完成以下需求
     * 已知有Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213}
     * a)	使用lambda表达式创建Predicate对象p1,p1能判断整数是否是自然数(大于等于0)
     * b)	使用lambda表达式创建Predicate对象p2,p2能判断整数的绝对值是否大于100
     * c)	使用lambda表达式创建Predicate对象p3,p3能判断整数是否是偶数
     * <p>
     * 遍历arr，仅利用已创建的Predicate对象(不使用任何逻辑运算符)，完成以下需求
     * i.	打印自然数的个数
     * ii.	打印负整数的个数
     * iii.	打印绝对值大于100的偶数的个数
     * iv.	打印是负整数或偶数的数的个数
     */
    public static void firstWork() {
        Integer[] arr = {-12345, 9999, 520, 0, -38, -7758520, 941213};
        Predicate<Integer> p1 = i -> i >= 0;
        Predicate<Integer> p2 = i -> Math.abs(i) > 100;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int num : arr) {
            if (p1.test(num)) {
                count1++;
            }
            if (p1.negate().test(num)) {
                count2++;
            }
            if (p2.and(p3).test(num)) {
                count3++;
            }
            if (p1.negate().or(p3).test(num)) {
                count4++;
            }
        }
        System.out.println("自然数的个数为：" + count1);
        System.out.println("负整数的个数为：" + count2);
        System.out.println("绝对值大于100的偶数的个数为：" + count3);
        System.out.println("是负整数或偶数的数的个数为：" + count4);
    }

    /**
     * 1.使用lambda表达式分别将以下功能封装到Function对象中
     * <p>
     * a)求Integer类型ArrayList中所有元素的平均数
     * <p>
     * b)将Map<String,Integer>中value存到ArrayList<Integer>中
     * <p>
     * 2.以学生姓名为key成绩为value创建集合并存储数据，使用刚刚创建的Function对象求学生的平均成绩
     */
    public static void secondWork() {
        Map<String, Integer> map = new HashMap<>() {
            {
                put("魏洪财", 59);
                put("梁文浩", 82);
                put("肖学斌", 98);
                put("王斌", 65);
                put("王大锤", 70);
            }
        };
        ArrayList<Integer> arrayList = new ArrayList<>() {
            {
                Collection<String> list = map.keySet();
                for (String s : list) {
                    add(map.get(s));
                }
            }
        };


    }
}
