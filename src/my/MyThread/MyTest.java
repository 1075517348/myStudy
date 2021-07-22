package my.MyThread;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        String property = System.getProperty("java.class.path");
        String[] propertys = property.split(":");
        Arrays.asList(propertys).stream().forEach(System.out::println);
    }
}