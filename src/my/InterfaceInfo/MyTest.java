package my.InterfaceInfo;

import jdk.jfr.Enabled;

public class MyTest {
    public static void main(String[] args) {
        /*Converter converter = Integer::valueOf;
        Integer converted = converter.conver("123");
        System.out.println(converted);
        new Derived(123);   */
        showObject(new Orange());

    }

    public static void showObject(Object object) {
        System.out.println(object);
        if (object instanceof Eatable) {
            ((Eatable) object).howToEat();
        }
    }
}

