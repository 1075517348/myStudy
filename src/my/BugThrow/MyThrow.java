package my.BugThrow;

import java.util.Random;
import java.util.Scanner;

public class MyThrow {
    static int avg(int number1, int number2) throws MyException {
        if (number1 < 0 || number2 < 0) {
            throw new MyException("不可使用负数");
        }
        if (number1 > 100 || number2 > 100) {
            throw new MyException("数值太大了");
        }
        return (number1 + number2) / 2;
    }

    public static void speak(int m) throws MyException {
        if (m > 1000) {
            throw new MyException("m不可大于1000");
        }
    }

    public static double count(double x, double y) {
        return x * y;
    }

    public static void main(String[] args) {
        try {
            speak(2);
        } catch (MyException e) {
            System.out.println(e);
        }
        try {
            int result = avg(102, 150);
            System.out.println(result);
        } catch (MyException e) {
            System.out.println(e);
        }
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            try {
                count(random.nextDouble(), random.nextDouble());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        try {
            gcd(-1, -2);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void gcd(int a, int b) throws MyException {
        if (a < 0 || b < 0) {
            throw new MyException("输入数字不可为负数");
        }
        int r = 1;
        if (a == 0 || b == 0) {
            System.out.print(a == 0 ? b : a);//a,b其中有0的情况
        } else {
            for (int i = 2; i <= a && i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    r = i;
                }
            }
        }
    }
}
